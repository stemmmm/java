# 다형성1

> 다형성의 개념에 대한 자세한 설명은 [여기](https://velog.io/@stemmmm/oop)를 참고하세요.

<br>

## 메모리 구조

```java
public class Parent {
    public void parentMethod() {
        System.out.println("parent method");
    }
}

public class Child extends Parent {
    public void childMethod() {
        System.out.println("child method");
    }
}

public class Main {
    public static void main(String[] args) {
        // 자식 인스턴스를 생성했으므로 부모 인스턴스도 함께 생성되며, 부모 타입의 변수가 자식 인스턴스를 참조하게 됨
        Parent parent = new Child();

        // 부모 타입인 polyChild는 parentMethod 호출 가능(단, 자식 타입의 childMethod는 호출 불가!)
        parent.parentMethod();
    }
}
```

<br>

## 타입 캐스팅

### 업캐스팅

```java
Parent parent = new Child();
parent.parentMethod();
parent.childMethod();  // 컴파일 에러
```

- `Child` 인스턴스를 `Parent` 타입으로 참조(자동 업캐스팅)
- `Child` 인스턴스를 생성할 때 `Parent` 인스턴스도 같이 생성하므로 위처럼 사용 가능
- 단, 위와 같이 선언하면 `Child`의 멤버에 접근할 수 없음

### 다운캐스팅

```java
Parent parent = new Child();
Child child = (Child) parent;
child.childMethod();
```

- 위 코드처럼 명시적인 다운캐스팅을 사용해 자식 클래스의 멤버에 접근할 수 있음
- 다운캐스팅을 잘못 사용하면 `ClassCastException` 발생 가능
- 위 코드의 경우 `Parent`와 `Child`의 인스턴스가 모두 존재하므로 `ClassCastException` 발생하지 않음
- 아래 코드의 경우 `Parent`의 인스턴스만 존재하므로 `Child` 타입으로 캐스팅이 불가능

```java
Parent parent = new Parent();
Child child = (Child) parent;  // ClassCastException 발생!
```

### `instanceof`

- `instanceof` 연산자를 활용해 변수가 참조하는 인스턴스의 타입을 확인할 수 있음
- 다운캐스팅의 안전한 사용을 위해 `instanceof` 연산자를 사용하는 것이 좋음
```java
Parent a = new Child();

if (a instanceof Child child) {
    child.childMethod();
}
```

<br>

## 오버라이딩과 메모리 구조

```java
public class Parent {
    public int value = 10;
    
    public void override() {
        System.out.println("parent override method");
    }
}

public class Child extends Parent {
    public int value = 20;

    @Override
    public void override() {
        System.out.println("child override method");
    }
}

public class Main {
    public static void main(String[] args) {
        Parent parent = new Child();
        System.out.println(parent.value);  // 10 출력
        parent.override();                 // "child override method" 출력
    }
}
```

- 자바에서는 메서드만 오버라이딩이 가능함
- 멤버 변수는 컴파일 타임에 정적으로 정해지므로 오버라이딩 불가능(참조하는 타입의 변수가 사용됨)
- `Child` 인스턴스를 참조하는 `Parent` 타입의 변수에서 `override` 메서드를 실행하면, `Child` 타입의 메서드가 런타임에 동적으로 바인딩되어 실행됨