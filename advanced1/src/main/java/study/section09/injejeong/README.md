# 생산자 소비자 문제2
## 해결방법: `Lock`, `Condition` 사용
- 생산자가 생산자를 깨우고 소비자가 소비자를 깨우는 비효율을 해결해야 함
- 두 개의 스레드 대기 집합을 만들어 생산자와 소비자가 같은 집합에서 대기하지 않게 함
- 생산자가 데이터를 생산하면 소비자 대기 집합에 알리고, 소비자가 데이터를 처리하면 생산자에게 알리는 구조
- `synchronized` 대신 `Lock lock = new ReentrantLock()` 사용
- `lock.newCondition()` 메서드를 호출하여 스레드 대기 공간 생성
```java
private final Lock lock = new ReentrantLock();
private final Condition producerCond = lock.newCondition();
private final Condition consumerCond = lock.newCondition();
```
- `condition.await()`: `wait()`와 유사, `ReentrantLock` 에서 획득한 락을 반납하고 지정한 `condition`에 현재 스레드를 대기(`WAITING`) 상태로 보관
- `condition.signal()`: `notify()` 와 유사, `ReentrantLock`을 가지고 있는 스레드가 지정한 `condition` 에서 대기중인 스레드를 꺼냄
  - `Queue` 구조를 사용하기 때문에 FIFO 순서로 깨움
## 해결방법: `BlockingQueue` 사용
- 큐가 특정 조건이 만족될 때까지 스레드의 작업을 차단
- 데이터가 없는 경우 소비자가 대기하도록 하고, 큐가 가득 찬 경우 생산자가 대기하게 만들어 스레드 간 충돌 방지
- 대표적인 구현체:
  - `ArrayBlockingQueue`: 고정된 버퍼 크기를 가진 배열 기반의 큐
  - `LinkedBlockingQueue`: 버퍼의 크기를 지정할 수도 있고, 무한한 크기로 사용할 수도 있는 연결 리스트 기반의 큐