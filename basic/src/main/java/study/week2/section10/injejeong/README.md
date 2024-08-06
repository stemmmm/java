# 다형성
- 객체 지향 프로그래밍의 특징 중 하나
- 하나의 객체가 다른 타입의 객체로 취급될 수 있는 능력
- 상위 타입은 자신을 포함한 하위 타입들을 참조할 수 있지만, 그 반대는 불가능
  - 1. `Parent poly = new Child();` → 가능
  - 2. `Child child = new Parent();` → 불가능, 컴파일 오류 발생
    - a와 같이 상위 타입의 변수 사용 시 자식 타입의 메서드 사용 불가
    - 이 때 다운캐스팅(downcasting) 사용 시 자식 타입에 접근 가능
    - ex) `Child child = (Child) poly;`
    - 다운캐스팅 수행 전 `instanceof` 키워드를 사용하여 변수가 참조하고 있는 인스턴스의 타입 확인 후 다운캐스팅을 하면 안전함

```java
public class Parent {
    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}

public class Child extends Parent {
    public void childMethod() {
        System.out.println("Child.childMethod");
    }
}

public class PolyMain {
    public static void main(String[] args) {
        // 다형적 참조: 부모 타입의 변수가 자식의 인스턴스를 참조
        Parent poly = new Child();
        // 부모 타입의 변수이므로 부모 메서드 호출 가능하지만 자식의 기능은 호출 불가
        poly.parentMethod();
        //poly.childMethod();
    }
}
```

## 다형성과 메서드 오버라이딩
- 오버라이딩된 메서드가 항상 우선권을 가짐
- 상위 클래스의 메서드가 하위 클래스에서 재정의되었다면 같은 이름을 가진 메서드를 호출하면 오버라이딩된 메서드를 실행