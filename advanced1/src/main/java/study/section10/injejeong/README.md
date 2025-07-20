# CAS - 동기화와 원자적 연산
## 원자적 연산
- 더 이상 나눌 수 없는 단위로 실행된 연산
- 멀티 스레드 상황에서도 다른 스레드의 간섭을 받지 않고 안전하게 처리됨
- ex) `value++`와 같이 변수가 인스턴스 필드에 선언되어 있는 연산의 경우 스레드 간 공유가 가능해지므로 멀티 스레드 상황에서 문제 발생 가능 (경쟁 조건)

## 해결 방법
- `synchronized` 블럭이나 `Lock`으로 임계 영역을 생성하여 공유 자원에 대한 일관성 유지
- `AtomicXxx` 클래스 - `AtomicInteger`, `AtomicLong`등
  - 특징
    - 원자성 보장
    - `Lock` 불필요: 블로킹 및 컨텍스트 스위칭 등의 성능 저하 없음
    - 단일 변수에 대한 카운트나 ID 생성 등 단순한 원자적 연산이 필요한 경우
    - 락을 사용하는 것보다 더 높은 성능을 요구하는 경우
    - 내부에 `volatile` 키워드로 선언되어 있으므로 가시성 문제 해결 

## CAS (Compare-And-Swap) 연산
- lock-free 기법: 락을 사용하지 않고 원자적 연산 수행 가능
- 작은 단위의 일부 영역에 적용 가능
- `V`, `A`, `B` 의 3가지 인자 사용
  - `V` (Variable/Value): 메모리 위치, 변경하려는 값이 저장된 메모리 주소
  - `A` (Expected): 예상되는 현재 값, 현재 메모리 위치 `V`에 있을 것이라 예상하는 값
  - `B` (New): 새로운 값, `A`와 `V`의 값이 일치할 경우, `V`를 업데이트 할 새로운 값
- 실행 흐름: 만약 `V`에 있는 현재 값이 `A`와 같다면, 그 값을 `B`로 업데이트 후 `true` 반환
  - 그렇지 않다면 `V`의 값을 변경하지 않고 `false` 반환
- 장점
  - 비블로킹 (Non-Blocking): 컨텍스트 스위칭으로 인한 오버헤드가 발생하지 않으므로 CAS 연산이 실패해도 다른 작업 수행 가능
  - 높은 동시성: 여러 스레드가 동시에 CAS 연산 시도 가능
  - 단점
    - 스핀락 (Spinlock) 가능성: CAS 연산 실패 시 성공할 때까지 시도, 이때 CPU 자원 낭비 가능성
- 따라서 충돌이 적은 간단한 연산 수행시 사용하는 것이 효율적
- CAS가 락을 대체한다?
  - 스레드를 직접적으로 블로킹하지 않고도 단일 변수의 원자성을 보장할 수 있다는 의미이지, `ReentrantLock`과 같은 복잡한 락 메커니즘 자체를 완전히 없앤다는 의미는 아님
```java
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(10);
        System.out.println("initial value = " + atomicInt.get());

        // 시도 1: 현재 값이 10이라면 20으로 변경
        // atomicInt의 현재 값(10)이 예상 값(10)과 일치하므로 20으로 변경 -> true 반환
        boolean result1 = atomicInt.compareAndSet(10, 20);
        System.out.println("result1 = " + result1);

        // 시도 2: 현재 값이 10이라면 30으로 변경
        // atomicInt의 현재 값(20)이 예상 값(10)과 다르므로 값 유지 -> false 반환
        boolean result2 = atomicInt.compareAndSet(10, 30);
        System.out.println("result2 = " + result2);

        // 시도 3: 현재 값이 20이라면 30으로 변경
        // atomicInt의 현재 값(20)이 예상 값(20)과 일치하므로 30으로 변경 -> true 반환
        boolean result3 = atomicInt.compareAndSet(20, 30);
        System.out.println("result3 = " + result3);
    }
}
```

## CAS 락
- CAS를 통해 하나의 스레드만 임계 영역에 진입하도록 보장하는 최소한의 락 구현 가능
- `ReentrantLock` 같은 고급 락들은 스핀락의 단점(CPU 낭비, 비공정성)을 보완하기 위해 CAS 기반의 매커니즘 활용