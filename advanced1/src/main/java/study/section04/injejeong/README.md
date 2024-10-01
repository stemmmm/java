# 스레드 제어와 생명 주기2
## `interrupt()`
- 스레드의 실행을 중단하거나 조정하고 싶을 때 사용
- `interrupt()` 메서드를 호출하여 다른 스레드 인터럽트
- `Thread.interrupted()` 또는 `isInterrupted()` 메서드로 확인
- 스레드가 인터럽트될 경우, `join()`, `sleep()` 등의 메서드는 `InterruptedException` 발생
- 이 예외를 처리하여 스레드 안전하게 종료
```java
public class MyRunnable implements Runnable {
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
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread.interrupt();
    }
}
```
## `yield()`
- 현재 실행 중인 스레드가 CPU를 다른 스레드에게 양보하도록 요청
- 스레드가 자신에게 할당된 실행 시간을 포기하고 다른 스레드에게 실행 기회 제공
```java
class MyThread implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + i + " 실행 중");
            Thread.yield();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        thread1.start();
        thread2.start();
    }
}
```