# 고급 동기화 - `concurrent.Lock`
## `LockSupport`
- `synchronized`의 단점인 무한 대기 문제와 공정성 문제를 해결하기 위한 클래스
- 무한 대기하지 않는 락 기능을 만들 수 있음
- `park()`: 스레드를 `WAITING` 상태로 변경
- `parkNanos(nanos)` : 스레드를 나노초 동안 `RUNNABLE`에서 `TIMED_WAITING` 상태로 변경
- `unpark(thread)` : `WAITING` 상태의 대상 스레드를 `RUNNABLE` 상태로 변경
  -  대기 상태의 스레드는 자신의 코드를 실행하지 못하기 때문에 `unpark`는 매개변수 필요
## `BLOCKED` vs `WAITING`
|상태|설명|인터럽트 처리|
|--|-----------|-------------|
| `BLOCKED`       |`synchronized`에서 락을 획득하기 위해 대기| 인터럽트가 걸려도 대기 상태 유지 |
| `WAITING`       |특정 조건이나 신호 대기|인터럽트가 걸리면 `RUNNABLE` 상태로 전환 |
| `TIMED_WAITING` |특정 시간 동안 대기|인터럽트가 걸리면 `RUNNABLE` 상태로 전환 |
## `Lock` 인터페이스
### `void lock()`
- 락 획득, 다른 스레드가 락 보유 시 현재 스레드는 락을 획득할 때까지 `WAITING` 상태로 대기
- 인터럽트에 무응답
### `void lockInterruptibly()`
- 락 획득, 다른 스레드가 락 보유 시 현재 스레드는 락을 획득할 때까지 `WAITING` 상태로 대기
- 대기 중 인터럽트가 발생 시 `InterruptedException` 발생, 락 획득 포기
### `boolean tryLock()`
- 락 획득 시도, 획득 여부 반환
- 획득 성공 시 `true`, 실패 시 `false` 반환
### `boolean tryLock(long time, TimeUnit unit)`
- 일정 시간동안 락 획득 시도
- 획득 성공 시 `true`, 실패 시 `false` 반환
- 대기 중 인터럽트가 발생 시 `InterruptedException` 발생, 락 획득 포기
### `void unlock()`
- 락 해제, 대기 중인 스레드 중 하나가 락 획득
- 락을 획득한 스레드만 호출 가능, 그렇지 않으면 `IllegalMonitorStateException` 발생
### `Condition newCondition()`
- `Condition` 객체를 생성하여 반환
- `Condition` 객체는 락과 결합되어 사용되며, 스레드가 특정 조건을 기다리거나 신호를 받을 수 있도록 함
## `ReentrantLock`
- `Lock` 인터페이스의 구현체
- 동기화 메커니즘을 제공하여 보다 세밀하게 스레드의 동기화를 관리
- 공정 모드와 비공정 모드로 설정 가능
### 공정 모드
- 먼저 대기한 스레드가 먼저 락을 획득
- 성능이 저하될 수 있음
### 비공정 모드
- `ReentrantLock`의 기본 모드
- 대기 중인 스레드 중 아무나 락 획득 가능
- 특정 스레드가 계속해서 락을 획득하지 못할 수 있음