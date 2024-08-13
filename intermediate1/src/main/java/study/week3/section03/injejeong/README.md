# String 클래스
- 문자열을 표현하는 클래스. 문자열을 조작할 때 핵심적인 역할을 하며, 다양한 문자열 관련 작업을 용이하게 해줌
- 이 클래스는 불변(immutable) 객체로, 문자열을 생성하고 조작하는 다양한 메서드를 제공
- 생성 방법
```java
String str = "Hello";               // 문자열 리터럴 사용
String str = new String("Hello");   // new 키워드 사용
```
- 주요 메서드
  - `length()` - 문자열의 길이를 반환
  - `charAt(index)` - 지정한 인덱스의 문자 반환
  - `substring()` - 지정한 범위의 부분 문자열 반환
  - `toLowerCase()`, `str.toUpperCase()` - 문자열 소문자 또는 대문자로 변환
  - `equals()`, `str.equalsIgnoreCase()` - 문자열 비교
  - `indexOf()` - 지정한 부분 문자열의 첫 번째 발생 인덱스 반환
  - `replace()` - 문자열에서 지정한 문자를 다른 문자로 대체
  - `trim()` - 문자열의 시작과 끝의 공백 제거
  - `concat()` - 두 문자열 결합
- 예외: String은 클래스이기 때문에 참조형이므로 `+`연산을 사용할 수 없지만, 편의상 `+`연산을 제공함
## String 클래스의 비교
- `==`는 객체의 참조를 비교하기 때문에, 두 문자열 객체가 동일한 메모리 주소를 참조하지 않다면 false를 반환
  - `String str1 = "Hello";`, `String str2 = "Java";`와 같이 문자열 리터럴 사용시 문자열 풀에 저장되기 때문에 이러한 경우 같은 참조값을 가지므로 `==` 비교에 성공
  - 문자열 풀: 메모리 효율성을 위해 문자열 리터럴을 관리하는 메커니즘으로 동일한 문자열 리터럴을 재사용하여 메모리 사용을 최적화
- `equals()`는 문자열의 내용이 동일한지를 비교하므로 문자열 비교에 적합
## String 클래스 - 불변 객체
- String은 불변 객체이므로 값의 변경이 필요할 시 기존 값은 변경되지 않고 새로운 객체를 만들어서 반환
```java
public class ImmutString {
    public static void main(String[] args) {
        String str = "Hello";
        str.concat(" World");    // 문자열이 합쳐지지 않음
        
        String str1 = "Hello";
        String str2 = str1.concat(" World");    // 새로운 변수에 저장
    }
}
```
## 불변 객체의 한계
- 문자를 더하거나 변경할 때 마다 계속해서 새로운 객체를 생성해야하기 때문에 컴퓨터의 메모리와 CPU의 낭비 초래 가능
- 이는 가변 String인 `StringBuilder`를 통해 해결 가능
## StringBuilder
- 문자열을 효율적으로 조작하기 위한 클래스
- 가변 객체이기 때문에 문자열을 직접 수정 가능
- `StringBuilder`를 사용하는 것이 더 좋은 경우
  - 반복문에서 반복해서 문자를 연결할 때
  - 조건문을 통해 동적으로 문자열을 조합할 때
  - 복잡한 문자열의 특정 부분을 변경해야 할 때
  - 매우 긴 대용량 문자열을 다룰 때
- 주요 메서드
  - `append()`: 문자열 추가
  - `insert()`: 지정된 위치에 문자열 삽입
  - `delete()`: 지정된 범위의 문자열 삭제
  - `replace()`: 지정된 범위의 문자열을 다른 문자열로 대체
  - `reverse()`: 문자열 반전
## 메서드 체이닝(Method Chaining)
- 각 메서드가 this를 반환하여 메서드를 연속해서 호출할 때 사용
- 코드의 가독성을 높이고, 코드 작성이 더 간결해질 수 있음
- `StringBuilder` 에서 문자열을 변경하는 대부분의 메서드도 메서드 체이닝 기법을 제공하기 위해 자기 자신을 반환
```java
public class Person {
    private String name;
    private int age;
    private String origin;

    public Person(String name) {
        this.name = name;
    }

    public Person setAge(int age) {
        this.age = age;
        return this;
    }
    
    public Person setOrigin(String origin) {
        this.origin = origin;
        return this;
    }
}
```
```java
public class PersonMain {
    public static void main(String[] args) {
        Person person = new Person("Mbappe")
                .setAge(25)
                .setOrigin("France");
    }
}
```