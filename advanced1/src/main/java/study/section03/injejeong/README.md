# 스레드 제어와 생명 주기1
## 스레드 상태
- `getState()`로 스레드의 현재 상태를 반환
  - `NEW`: 스레드가 아직 시작되지 않은 상태
  - `RUNNABLE`: 스레드가 실행 중이거나 실행될 준비가 된 상태
    - `NEW` → `start()` → `RUNNABLE`
  - `BLOCKED`: 스레드가 동기화 락을 기다리는 상태
  - `WAITING`: 스레드가 다른 스레드의 특정 작업이 완료되기를 기다리는 상태
    - `RUNNING` → `join()`, `sleep()` → `WAITING`
  - `TIMED_WAITING`: 일정 시간 동안 기다리는 상태
  - `TERMINATED`: 스레드가 실행을 마친 상태
    - `RUNNING` → `run()` 종료 → `TERMINATED`
## `join()`
- 스레드가 다른 스레드의 작업이 완료될 때까지 무한정 대기(`WAITING`)
```java
class MyThread extends Thread {
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // 스레드 시작

        try {
            thread.join(); // 종료될 때까지 대기
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
```