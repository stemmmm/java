# 생산자-소비자 문제2

## 개선1: `Lock`과 `Condition` 사용
- 생산자가 생산자 스레드를 깨우고, 소비자가 소비자 스레드를 깨우는 비효율을 개선해야함
- 즉, 생산자는 소비자를 깨워야하고, 소비자는 생산자를 깨워야함
- 이는 생산자 스레드 대기 집합과 소비자 스레드 대기 집합을 `Condition`으로 분리하여 해결할 수 있음

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BoundedQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition producerCondition = lock.newCondition();  // 생산자 스레드 대기 집합
    private final Condition consumerCondition = lock.newCondition();  // 소비자 스레드 대기 집합

    private final Queue<String> queue = new ArrayDeque<>();
    private final int maxSize;

    public BoundedQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(String data) {
        lock.lock();
        
        try {
            while (queue.size() == maxSize) {
                log.info("큐가 가득차 생산자가 대기합니다.");

                try {
                    producerCondition.await();
                    log.info("생산자가 깨어났습니다.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            queue.offer(data);
            log.info("생산자가 데이터를 저장한 다음 consumerCondition의 signal() 메서드를 호출했습니다.");
            consumerCondition.signal();   
        } finally {
            lock.unlock();
        }
    }

    public String take() {
        lock.lock();

        try {
            while (queue.isEmpty()) {
                log.info("큐가 비어있어 소비자가 대기합니다.");
                
                try {
                    consumerCondition.await();
                    log.info("소비자가 깨어났습니다.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            String data = queue.poll();
            log.info("소비자가 데이터를 꺼낸 다음 producerCondition의 signal() 메서드를 호출했습니다.");
            producerCondition.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
```

<br>

## 개선2: `BlockingQueue` 사용
- 자바는 생산자-소비자 문제를 해결하기 위한 `BlockingQueue` 인터페이스를 제공함
- `BlockingQueue`의 구현체들은 내부적으로 위 코드와 비슷한 로직으로 동작함
- `ArrayBlockingQueue`, `LinkedBlockingQueue` 등의 구현체 존재