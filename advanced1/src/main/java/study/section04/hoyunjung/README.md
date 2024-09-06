# 스레드 제어와 생명 주기2

## 인터럽트
- 다른 스레드의 작업을 중간에 중단하기 위해 사용하는 신호

```java
public class Interrupt {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();
        
        Thread.sleep(100);
        thread.interrupt();
        System.out.println("스레드 인터럽트 상태1: " + Thread.currentThread().getState());  // true
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            while (!Thread.interrupted()) {  // 스레드 인터럽트 상태 정상(false)으로 변경
                System.out.println("작업 중...");
            }

            System.out.println("스레드 인터럽트 상태2: " + Thread.currentThread().getState());  // false

            try {
                Thread.sleep(1_000);
                System.out.println("자원 정리 완료!");
            } catch (InterruptedException e) {
                System.out.println("인터럽트 발생하여 자원 정리 실패");
                System.out.println("스레드 인터럽트 상태3: " + Thread.currentThread().getState());
            }
        }
    }
}
```

<br>

## `yield`
- 다른 스레드에게 CPU를 양보하고 싶을때 사용
- `yield` 메서드를 호출한 스레드는 `RUNNABLE` 상태를 유지하며 스케줄링 큐(대기 큐)로 들어감
- 따라서 양보할 스레드가 없거나 CPU가 남으면 `yield` 메서드를 호출해도 계속 본인이 실행될 수 있음

```java
public class Yeild {
    static final int THREAD_COUNT = 1_000;  // 양보할 수 있도록 많은 스레드 생성

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyTask());
            thread.start();
        }
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                Thread.yield();
            }
        }
    }
}
```