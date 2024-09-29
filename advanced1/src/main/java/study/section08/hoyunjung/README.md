# 생산자-소비자 문제1

## 개념
- 멀티스레딩 환경에서 발생할 수 있는 대표적인 동기화 문제
- 여러 생산자와 소비자 스레드가 버퍼를 사용할 때, 스레드 간 동기화 문제가 발생할 수 있음
- 한정된 버퍼 문제(Bounded-buffer problem)라고도 부름
- 생산자(Producer): 데이터를 생산하여 버퍼에 저장하는 역할
- 소비자(Consumer): 버퍼에 저장된 데이터를 사용하는 역할
- 버퍼(Buffer): 생산자가 생산한 데이터를 소비자가 소비하기 전까지 일시적으로 저장하는 공간

<br>

## 해결법: `Object`의 `wait()`, `notify()` 메서드 사용
- 객체 내부에 존재하는 하나의 스레드 대기 집합에서 생산자, 소비자 스레드를 관리
- 즉, `notify()`를 호출할 때 대기 집합에서 어떤 스레드가 선택될지 알 수 없어 생산자가 생산자 스레드를, 소비자가 소비자 스레드를 깨우는 비효율이 발생할 수 있음
- 또한 어떤 스레드가 실행될지 알 수 없으므로 기아 문제가 발생할 수 있음
- `notifyAll()` 메서드를 사용해 기아 문제를 해결할 수 있지만, 매번 모든 스레드를 깨워야하는 비효율 발생

```java
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

@Slf4j
class BoundedQueue {
    private final Queue<String> queue = new ArrayDeque<>();
    private final int maxSize;

    public BoundedQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    // 생산자가 큐에 데이터 저장
    public synchronized void put(String data) {
        while (queue.size() == maxSize) {
            log.info("큐가 가득차 생산자가 대기합니다.");

            try {
                wait();  // 상태 변경(RUNNABLE -> WAITING) 및 락 반납
                log.info("생산자가 깨어났습니다.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        queue.offer(data);
        log.info("생산자가 데이터를 저장한 다음 notify() 메서드를 호출했습니다.");
        notify();  // 대기 중인 스레드 WAITING -> BLOCKED
        // notifyAll();
    }

    // 소비자가 큐에서 데이터 소비
    public synchronized String take() {
        while (queue.isEmpty()) {
            log.info("큐가 비어있어 소비자가 대기합니다.");

            try {
                wait();  // 상태 변경(RUNNABLE -> WAITING) 및 락 반납
                log.info("소비자가 깨어났습니다.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String data = queue.poll();
        log.info("소비자가 데이터를 꺼낸 다음 notify() 메서드를 호출했습니다.");
        notify();  // 대기 중인 스레드 WAITING -> BLOCKED
        // notifyAll();
        return data;
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
```