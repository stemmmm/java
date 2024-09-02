# Object 클래스
## java.lang 패키지
- 자바에서 가장 기본적이고 중요한 클래스들을 포함
- 자바의 핵심 라이브러리로, 자바 프로그램의 기본적인 기능을 제공하는 클래스들을 포함
- 자바 프로그래밍을 할 때 자주 사용되는 클래스가 많고, 모든 자바 애플리케이션에 자동으로 `import`되므로 `import`를 하지 않아도 사용 가능
- java.lang 패키지의 대표적인 클래스들
  - Object: 모든 자바 객체의 부모 클래스
  - String: 문자열
  - Integer , Long , Double: 래퍼 타입, 기본형 데이터 타입을 객체로 만든 것
  - Class: 클래스 메타 정보
  - System: 시스템과 관련된 기본 기능들을 제공
## Object 클래스
- 모든 클래스의 최상위 부모 클래스가 되는 클래스
- 모든 클래스가 이 클래스를 상속받기 때문에, 자바의 모든 객체는 Object 클래스의 메서드 사용 가능
- 객체의 정보, 객체 간의 동등성 및 동일성 비교 등과 같은 기본적 기능들을 포함
- 다형성을 지원하는 기본적인 메커니즘을 제공하므로 다양한 타입의 객체를 통합적으로 처리할 수 있게 해줌
```java
public class Parent {
    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
```
```java
// 자바에서 자동으로 `extends Object` 코드를 넣어줌. 위의 코드와 아래의 코드는 동일
public class Parent extends Object {
    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
```
- 명시적으로 상속받을 부모 클래스를 정의하지 않으면 Object 클래스를 상속받음
## Object 클래스 다형성
```java
class Dog {
    public void sound() {
        System.out.println("멍멍");
    }
}

class Cat {
    public void sound() {
        System.out.println("야옹");
    }
}

public class ObjectPolyExample1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        action(dog);
        action(cat);
    }
    
    private static void action(Object obj) {
        // 어떤 객체를 참조하고 있는지 확인하는 동시에 다운캐스팅
        if (obj instanceof Dog dog) {
            dog.sound();
        } else if (obj instanceof Cat cat) {
            cat.sound();
        }
    }
}
```
- Object 클래스는 최상위 부모 클래스이므로 `obj`는 모든 하위 클래스의 객체에 접근 가능
## Object 배열
```java
public class ObjectPolyExample1 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Object obj = new Object();

        Object[] objects = {dog, car, object};
    }
}
```
- 위와 같이 Object 타입으로 모든 객체를 담을 수 있는 배열 생성 가능
## toString()
- 객체의 정보를 문자열의 형태로 제공하는 메서드
```java
public class ObjectPrinter {
    public static void print(Object obj) {
        String string = "객체 정보 출력: " + obj.toString();
        System.out.println(string);
    }
}
```
## equals()
- 객체의 동일성과 동등성을 알 수 있게 하는 메서드
  - 동일성(identity): `==` 연산자를 사용하여 두 객체의 메모리 주소를 비교하여 동일한 인스턴스인지를 확인
  - 동등성(equality): Object 클래스에서 정의되어 있는 `equals()` 메서드를 사용하여 두 객체가 논리적으로 동일한지(객체의 내용이 같은지) 확인