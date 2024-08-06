# 추상 클래스
- 부모 클래스는 제공하지만, 생성되면 안되는 클래스
- 상속을 목적으로 하며, 인스턴스가 존재하지 않음
- 선언 시 `abstract` 키워드 사용

## 추상 메서드
- 자식 클래스에서의 메서드 오버라이딩을 강제할 수 있음
- 오버라이딩을 하지 않으려면 자식 클래스도 추상 클래스여야 함
- 추상적인 개념만 제공하기 때문에, 바디가 존재하지 않으며, 이를 자식 클래스에서 완성
- 추상 메서드가 하나라도 존재하면 해당 클래스는 추상 클래스로 선언해야 함
- 추상 메서드로만 이루어진 클래스를 '순수 추상 클래스'라고 함

```java
public abstract class AbstractAnimal {
    public abstract void sound();
}
```
```java
public abstract class Dog extends AbstractAnimal {
    @Override   // 자식 클래스에서 오버라이딩
    public void sound() {
        System.out.println("멍멍");
    }
}
```

## 인터페이스
- 순수 추상 클래스를 더 편리하게 사용할 수 있도록 해줌
- `interface` 키워드 사용, `implements`로 하위 클래스에서 구현 가능
- 인터페이스의 메서드는 `public`, `abstract`로 간주되며, 앞의 두 키워드 생략 가능
- 상속과 달리 다중 구현 가능
```java
public interface InterfaceAnimal {
    void sound();
    void move();
}
```
```java
public class Dog implements InterfaceAnimal { 
    @Override
    public void sound() {
        System.out.println("멍멍");
 }
 
    @Override
    public void move() {
        System.out.println("개 이동");
 }
}
```