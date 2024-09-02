## 생성자
- 자바 클래스의 객체를 생성하기 위함
- 객체를 생성하는 동시에 초기화가 가능해져 중복 호출을 제거하고 필수값 입력 보장 가능
- 클래스에 생성자가 하나도 없으면 컴파일러가 기본 생성자 제공
```java
public class Constructor {
    public Constructor() {
    }
}
```
## this
- 인스턴스 변수와 매개변수를 구분하기 위한 예약어
- 둘의 이름을 다르게 하는 대신에 쓸 수 있음
```java
public class Member {
    String name;
    String phone;
    int age;
    
    public Member(String name, String phone, int age) {
        this.name = name;
        this.phone = phone;
        this.age = age;
    }
}
```