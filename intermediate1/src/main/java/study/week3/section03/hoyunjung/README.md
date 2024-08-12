# `String` 클래스

## 내부 구현

- `byte` 배열을 사용해 문자열 값을 보관함(자바 9 이전에는 `char` 배열 사용)
- Latin-1 인코딩(영어, 숫자)의 경우 1B 사용, 나머지의 경우(UTF-16) 2B 사용
- 기존 `char` 배열은 모든 문자에 2B를 사용해 비효율적이었음

```java
public final class String {
    private final byte[] value;
    // ...
}
```

<br>

## 문자열 풀

- 문자열 리터럴들은 자바가 실행되는 시점에 힙의 문자열 풀에 인스턴스가 생성됨
- 동일한 문자열 리터럴의 경우, 하나의 인스턴스를 공유함 -> 효율적인 메모리 사용
- 문자열 풀에서 문자열을 찾을때는 해시 알고리즘을 사용하므로 매우 빠른 속도로 원하는 인스턴스를 찾을 수 있음

<br>

## 불변 객체 `String`

- `String` 클래스는 불변 객체로 설계되었으므로, 문자열 덧셈 연산을 반복하면 매번 새로운 객체를 생성해 오버헤드가 매우 큼
- 심지어 연산의 중간 결과는 사용하지 않으므로, 사용하지 않는 객체에 대한 GC도 필요함
- 따라서 많은 문자열 연산을 하는 경우 가변 객체인 `StringBuilder`를 사용하는 것이 적절함
- 사이드 이펙트를 방지하기 위해 `StringBuilder`를 사용한 문자열 연산이 끝나면 `toString()` 메서드를 통해 불변 객체인 `String`으로 변환하는 것이 좋음

<br>

## `String` 최적화

- 자바 컴파일러는 문자열 리터럴을 더하는 부분을 자동으로 합쳐줘 런타임에 발생할 메모리 낭비를 막음
  ```java
  String hello = "Hello, " + "World!"; --컴파일--> String hello = "Hello, World!";
  ```

- 자바 컴파일러는 문자열 변수를 더하는 부분을 자동으로 합쳐줘 런타임에 발생할 메모리 낭비를 막음
  ```java
  String hello = "Hello, ";
  String world = "World!";
  String helloWorld = hello + world; --컴파일--> String helloWorld = new StringBuilder().append(hello).append(world).toString();
  ```

- 단, 반복문과 같이 복잡한 경우는 자동 최적화가 어려우므로 직접 `StringBuilder` 클래스를 사용해야함

<br>

## `StringBuffer` 클래스

- `StringBuilder`와 기능은 동일하지만, 쓰레드 안전성이 추가된 클래스
- 즉, 쓰레드 안전성이 필요한 경우 사용하면 되며, 필요하지 않은 경우라면 동기화 오버헤드가 존재하므로 사용할 필요 없음