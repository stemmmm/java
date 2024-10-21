# IO 기본1

## 스트림(Stream)
- 외부와 데이터를 주고 받는 과정을 입출력(I/O, Input/Output)이라고 부름
- 스트림은 데이터를 주고받는 흐름을 추상화한 개념이며, 입력 스트림과 출력 스트림으로 나뉨
- 입력 스트림: 외부에서 데이터를 읽어오는 스트림
- 출력 스트림: 데이터를 외부로 출력하는 스트림
- 스트림은 단방향이며, 입력과 출력 스트림이 독립적으로 동작함

> **주의**  
> 사용이 완료된 스트림은 항상 close() 메서드를 사용하여 닫아야 함  
> 스트림을 닫지 않으면 파일 핸들 또는 네트워크 리소스가 계속 점유되어 리소스 누수가 발생할 수 있음

<br>

## `InputStream`
- 입력 스트림을 위한 추상 클래스
- 주요 메서드로는 `read()`, `read(byte[])`, `readAllBytes()`가 있음
- 주요 하위 클래스로는 `FileInputStream`, `ByteArrayInputStream`, `SocketInputStream` 등이 있음

### `FileInputStream`
- 파일로부터 데이터를 읽는 스트림
- 대용량 파일을 읽을 때는 `OutOfMemoryError`를 방지하기 위해 `read(byte[], offset, length)` 메서드를 사용하여 부분적으로 데이터를 읽어와야 함
- 작은 파일이거나 모든 데이터를 한 번에 처리해야 하는 작업이 필요한 경우, `readAllBytes()` 메서드를 사용해 한 번에 모든 데이터를 읽어올 수 있음

<br>

## `OutputStream`
- 출력 스트림을 위한 추상 클래스
- 주요 메서드로는 `write(int)`,`write(byte[])`가 있음
- 주요 하위 클래스로는 `FileOutputStream`, `ByteArrayOutputStream`, `SocketOutputStream` 등이 있음

<br>

## 버퍼링(Buffering)
- 버퍼링은 데이터를 일정량 모아 한 번에 처리함으로써 입출력 성능을 최적화하는 기법임
- 버퍼링을 사용하면 시스템 콜 호출 횟수와, 디스크 접근 횟수가 줄어들어 성능이 향상됨
- 하지만 버퍼의 크기가 커진다고 해서 성능이 무조건 향상되지는 않음
- 파일 시스템에서 데이터를 읽고 쓰는 단위인 블록의 크기는 보통 4KB나 8KB이기 때문에, 이 크기 이상의 버퍼는 성능에 큰 이점을 주지 않음
- 따라서 일반적으로 4KB나 8KB의 버퍼를 사용하는 것이 효율적임
- 성능 최적화를 위해서는 `BufferedInputStream`과 `BufferedOutputStream`을 사용하여 입출력 작업을 처리하는 것이 권장됨
- `BufferedInputStream`과 `BufferedOutputStream`은 버퍼를 직접 구현하여 사용하는 것보다는 느리지만 thread-safe 함
