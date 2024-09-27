# CAS - 동기화와 원자적 연산

## 원자적 연산
- 더 이상 나눌 수 없는 단위의 연산
- 실행 중간에 끼어들 수 없고, 연산이 완전히 실행되거나 전혀 수행되지 않는 방식으로 동작함(all or nothing)
- `synchronized`나 `Lock`을 사용해 여러 연산을 하나의 원자적인 단위로 묶을수 있음 

<br>

## CAS 연산
- CAS(Compare-and-Swap) 연산을 사용하면 락을 사용하지 않고도 일정 부분 원자적 연산을 수행할 수 있음
- CAS 연산의 원자성은 하드웨어(CPU) 차원에서 보장되며, 메모리 특정 위치의 값이 예상한 값과 일차하면 새로운 값으로 변경하는 형태로 동작함
- 만약 현재 값이 예상한 값과 일치하지 않으면, 값을 변경하지 않고 busy waiting 방식으로 재시도함
- 따라서 충돌이 적은 환경에서는 락보다 성능이 좋지만, 충돌이 많이 발생하는 환경에서는 락에 비해 성능이 떨어질 수 있음
- 일반적인 경우, 동기화 락을 사용하고 간단한 연산의 경우에만 CAS 연산의 사용을 권장함

```java
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();  // 초기값: 0
        System.out.println("초기값: " + atomicInteger.get());

        // 현재 값 0이면 1로 세팅(원자적 실행)
        boolean result1 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result1: " + result1);
        System.out.println("현재값: " + atomicInteger.get());

        // 현재 값 1이라 실패(원자적 실행)
        boolean result2 = atomicInteger.compareAndSet(0, 1);
        System.out.println("result2: " + result2);
        System.out.println("현재값: " + atomicInteger.get());
    }
}
```

<br>

## CAS 락
- 락을 획득하는 연산 자체를 CAS 연산으로 구현할 수 있음
- 이때, 락을 획득하는 과정에서 다른 스레드가 락을 이미 획득한 상태인 경우, busy waiting을 통해 락이 해제될 때까지 재시도함