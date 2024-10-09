# 스레드 풀과 `Executor` 프레임워크1

## 스레드 풀
- 스레드 풀은 일정 수의 스레드를 미리 생성해 두고 재사용하는 기법임
- 스레드를 사용할 때마다 새로 생성하는 것보다 스레드 풀의 미리 생성된 스레드를 재사용하는 것이 효율적임
- 스레드 풀을 사용하면 스레드 생성 비용을 줄일 수 있고, 전체 스레드 수를 제한하여 자원 낭비를 방지할 수 있음
- 또한, `Executor` 프레임워크는 `Runnable` 인터페이스의 불편한 점인 `run()` 메서드에 리턴 값이 없고 체크 예외를 던질 수 없는 점을 `Callable`과 `Future` 인터페이스를 통해 해결함

<br>

## `Executor` 인터페이스
- 가장 단순한 작업 실행 인터페이스

```java
package java.util.concurrent;

public interface Executor {
    void execute(Runnable command);
}
```

<br>

## `ExecutorService` 인터페이스
- `Executor`를 확장해 작업 제출과 제어 기능을 제공함
- 실제로 사용하는 인터페이스이며, 기본 구현체는 `ThreadPoolExecutor`임
- `ThreadPoolExecutor`의 생성자에서는 스레드 풀에서 관리되는 기본 및 최대 스레드 개수, 작업을 보관할 블로킹 큐 등을 받음

### 주요 메서드 정리
- `void execute(Runnable command)`: `Runnable` 작업 제출
- `<T> Future<T> submit(Callable<T> task)`: `Callable` 작업을 제출하고 결과를 리턴받음
- `Future<?> submit(Runnable task)`: `Runnable` 작업을 제출하고 결과를 리턴받음

```java
public interface ExecutorService extends Executor, AutoCloseable {
    // 종료 메서드
    void shutdown();
    List<Runnable> shutdownNow();
    boolean isShutdown();
    boolean isTerminated();
    boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException;
    
    // 단일 실행
    <T> Future<T> submit(Callable<T> task);
    <T> Future<T> submit(Runnable task, T result);
    Future<?> submit(Runnable task);
    
    // 다수 실행
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException;
    <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException;
    <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException;
    <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
    
    @Override
    default void close() {...}  // 자바 19부터 제공
}
```