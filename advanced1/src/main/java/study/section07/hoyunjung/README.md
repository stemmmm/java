# 고급 동기화
- Lock 인터페이스
  - 메서드
- ReentrantLock
  - 동작방식
  - 공정 모드
  - 비공정 모드

## `LockSupport`
- `synchronized`의 무한 대기 문제를 해결할 수 있지만, `LockSupport`는 저수준에서 직접 구현해야 하기 때문에 사용이 어려움
- 따라서 더 높은 수준의 동기화 메커니즘인 `Lock` 인터페이스와 `ReentrantLock`을 주로 사용함

### `static void park()`
- 해당 메서드를 호출한 스레드는 `WAITING` 상태가 됨

### `static void parkNanos(long nanos)`
- 해당 메서드를 호출한 스레드는 `TIMED_WAITING` 상태가 됨

### `static void unpark(Thread thread)`
- 지정한 스레드의 상태를 `WAITING`에서 `RUNNABLE` 상태로 전환함


<br>

### `BLOCKED` vs `WAITING`, `TIMED_WAITING`
| 상태              | 설명                                | CPU 스케줄링 | 인터럽트 | 사용 예시                                                                                        |
|-----------------|-----------------------------------|----------|------|----------------------------------------------------------------------------------------------|
| `BLOCKED`       | 모니터 락을 기다리는 상태                    | 불가능      | 불가능  | `synchronized` 블럭이나 메서드                                                                      |
| `WAITING`       | 다른 스레드의 작업이 완료되길 무한정 기다리는 상태      | 불가능      | 가능   | `Object.wait()`, `Thread.join()`, `LockSupport.park()`                                       |
| `TIMED_WAITING` | 다른 스레드의 작업이 완료되길 일정 시간 동안 기다리는 상태 | 불가능      | 가능   | `Object.wait(long timeout)`, `Thread.join(long millis)`, `LockSupport.parkNanos(long nanos)` |

<br>

## `Lock` 인터페이스

> **주의**  
> `Lock` 인터페이스에서의 락은 객체마다 갖는 모니터 락이 아닌 `ReentrantLock`이 제공하는 기능을 말하며, 모니터 락은 `synchronized`에서만 사용함

### `void lock()`
- 락을 획득함
- 만약 다른 스레드가 이미 락을 획득했다면, 현재 스레드는 락을 획득할 때까지 `WAITING` 상태로 대기함
- `WAITING` 상태지만 인터럽트가 발생해도 무시하고 락 획득을 기다림

### `void lockInterruptibly()`
- 락을 획득함
- 만약 다른 스레드가 이미 락을 획득했다면, 현재 스레드는 락을 획득할 때까지 `WAITING` 상태로 대기함
- 대기 중 인터럽트가 발생하면 `InterruptedExeption`이 발생하며 락 획득을 포기함

### `boolean tryLock()`
- 락을 획득하려고 시도한 후, 즉시 성공 여부를 반환함
- 락 획득 성공: `true` 반환 
- 락 획득 실패: 다른 스레드가 이미 락을 가지고 있으면 대기하지 않고 `false` 반환

### `boolean tryLock(long time, TimeUnit unit)`
- 주어진 시간 동안 락을 획득하려고 시도함
- 주어진 시간 내에 락 획득 성공: `true` 반환
- 주어진 시간 내에 락 획득 실패: 대기 시간이 지나면 `false` 반환

### `void unlock()`
- 락을 해제함
- 락을 획득한 스레드만 호출할 수 있으며, 락을 해제하면 대기 중인 스레드 중 하나가 락을 획득할 수 있음

<br>

## `ReentrantLock` 
- `Lock` 인터페이스의 구현체이며 스레드가 공정하게 락을 획득할 수 있는 모드를 제공함
- 공정 모드(fair mode)와 비공정 모드(non-fair mode)가 있음

### 비공정 모드
- 기본 모드이며, 대기 중인 스레드 중 아무나 락을 획득할 수 있음
- 대기 중인 스레드 중 어떤 것이 락을 획득할지 예측할 수 없으며, 특정 스레드가 계속해서 락을 획득하지 못할 수 있음

### 공정 모드
- 락을 요청한 순서대로 락을 획득할 수 있음
- 모든 스레드가 락을 요청한 순서대로 공정하게 획득할 수 있지만, 락을 획득하는 속도가 느려질 수 있음