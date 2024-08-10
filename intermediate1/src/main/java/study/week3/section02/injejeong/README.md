# 불변 객체
## 기본형과 참조형의 공유
- 기본형 변수는 같은 값을 공유하지 않지만 참조형 변수는 참조값을 통해 같은 객체에 접근할 수 있다.
- 따라서 참조형에서는 공유 참조에 따른 사이드 이펙트(side effect)가 발생할 수 있다.
- 사이드 이펙트: 특정 부분에서 발생한 변경이 다른 곳에서도 영향을 미치는 것
  - 특정 코드의 변경으로 인해 의도치 않게 다른 부분도 변경될 수 있기 때문에 객체의 상태를 추적 및 변경하는 데에 어려움이 있음
```java
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class SharedObjectExample {
    public static void main(String[] args) {
        Person person1 = new Person("Mbappe");
        Person person2 = person1;

        person2.setName("Bellingham");
        
        // 공유 참조의 사이드 이펙트 발생, 모두 Bellingham으로 변경됨
        System.out.println("Person1: " + person1);
        System.out.println("Person2: " + person2);
    }
}
```
## 공유 참조로 인한 사이드 이펙트의 해결방안
  - `person1`과 `person2`가 서로 다른 인스턴스 참조
```java
public class SharedObjectExample {
    public static void main(String[] args) {
        Person person1 = new Person("Mbappe");
        Person person2 = new Person("Mbappe");

        person2.setName("Bellingham");
        System.out.println("Person1: " + person1);
        System.out.println("Person2: " + person2);
    }
}
```
- 불변 객체 사용
```java
public class ImmutPerson {
    // final로 선언
    private final String name;

    // 생성자로 값 설정 후 변경 불가
    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

/*  Setter 삭제
    public void setName(String name) {
        this.name = name;
    }
*/

    @Override
    public String toString() {
        return name;
    }
}
```