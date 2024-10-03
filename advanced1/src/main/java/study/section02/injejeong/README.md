# 스레드 생성과 실행
## 스레드
- 멀티 스레딩을 통해 여러 작업을 동시에 수행할 수 있게 해주는 기능
- `Thread` 클래스를 확장하거나 `Runnable` 인터페이스로 스레드 구현
## 스레드 생성 - `Thread` 상속
- `Thread` 클래스를 상속하고, 스레드가 실행할 코드를 `run()` 메서드 오버라이드
- `start()` 메서드로 스레드 실행
```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
}

public class ThreadMain {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start(); // 스레드 시작
    }
}
```
## 스레드 생성 - `Runnable` 구현
- `Runnable` 인터페이스를 구현한 후, `Thread` 객체를 생성하여 스레드를 실행
- `run()` 메서드 내에서 처리할 작업을 정의하며, 여기서 발생할 수 있는 예외를 적절히 처리
- 스레드 생성 시 `Runnable` 인터페이스를 구현하는 방식 권장
- 스레드와 실행할 작업을 명확히 분리하고, 인터페이스를 사용하므로 더 유연하고 유지보수 용이
```java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": run()");
    }
}

public class RunnableMain {
    public static void main(String[] args) {
        RunnableMain runnable = new RunnableMain();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
```
## 데몬 스레드 / 사용자 스레드
- 데몬 스레드
    - 백그라운드에서 실행되는 스레드
    - 일반 스레드와는 달리 애플리케이션이 종료될 때 자동으로 종료됨
- 사용자 스레드
    - 사용자가 생성하는 스레드로, 주로 메인 스레드와 함께 실행되어 주요 작업을 수행
      - 작업이 완료될 때까지 실행되며, 모든 사용자 스레드가 종료되면 JVM도 종료