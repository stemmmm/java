# 스레드 생성과 실행

## 스레드 생성

### Thread 상속
- `Thread` 클래스를 상속해 스레드를 정의할 수 있음
- `run` 메서드에 스레드가 실행할 코드를 정의하면 됨
- 정의한 스레드를 실행하고 싶으면 `start` 메서드를 반드시 호출해야함(`run` 메서드는 호출하면 안됨)
- 여러 스레드를 실행할 시 스레드간 실행 순서는 보장되지 않음

```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
```

### Runnable 구현
- `Runnable` 인터페이스를 구현해 스레드를 정의할 수 있으며, 익명 클래스나 람다를 사용할 수 있음
- `Runnable` 인터페이스의 구현체를 `Thread`의 생성자로 전달하여 `start` 메서드를 실행하는 형태로 실행할 수 있음
- `Thread` 상속보다 `Runnable` 구현을 통해 스레드를 정의하는 방식이 권장됨
  - 이유1: `Thread`를 상속한 클래스는 다른 클래스를 상속받을 수 없어 유연성이 떨어지므로
  - 이유2: 여러 스레드가 동일한 `Runnable` 객체를 공유할 수 있어 효율적인 자원 관리가 가능하므로

```java
public class Main {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().getName()));
        thread.start();
    }
}
```

 <br>

## 데몬 스레드, 유저 스레드
- 데몬 스레드: 백그라운드에서 보조 작업 수행, 모든 유저 스레드가 종료되면 데몬 스레드는 자동으로 종료
- 유저 스레드: 주요 작업 수행, 모든 유저 스레드가 종료되면 JVM도 종료
- 스레드를 `start` 하기 전 `Thread` 클래스의 `daemon` 필드를 `true`로 설정해주면 데몬 스레드로 동작함