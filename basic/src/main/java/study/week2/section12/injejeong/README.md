## 다형성의 본질
- 역할(인터페이스)과 구현(인터페이스를 구현한 클래스, 구현 객체)을 분리
  - 클라이언트는 대상의 역할만 알면 이를 사용할 수 있다.
  - 클라이언트는 구현 대상의 내부 구조를 몰라도 되고, 이것이 변경되어도 영향을 받지 않음
- 확장 가능한 설계
- 클라언트를 변경하지 않으면서 서버에 구현된 기능을 유연하게 변경할 수 있음

```java
public interface Car {
    void startEngine();
    void offEngine();
    void pressAccelerator();
} 
```
```java
public class K3Car implements Car {
    @Override
    public void startEngine() {
        System.out.println("K3Car.startEngine");
    }
    
    @Override
    public void offEngine() {
        System.out.println("K3Car.offEngine");
    }
    @Override
    public void pressAccelerator() {
        System.out.println("K3Car.pressAccelerator");
    }
}
```
```java
public class Model3Car implements Car {
    @Override
    public void startEngine() {
        System.out.println("Model3Car.startEngine");
    }
    
    @Override
    public void offEngine() {
        System.out.println("Model3Car.offEngine");
    }
    @Override
    public void pressAccelerator() {
        System.out.println("Model3Car.pressAccelerator");
    }
}
```
```java
public class Driver {
    private Car car;
    public void setCar(Car car) {
    System.out.println("자동차를 설정합니다: " + car);
    this.car = car;
    }
    
 public void drive() {
    System.out.println("자동차를 운전합니다.");
    car.startEngine();
    car.pressAccelerator();
    car.offEngine();
 }
}
```
- `Driver` 클래스에서 운전자는 자동차의 모델에 의존하지 않고 차의 역할에만 의존
- 클라이언트인 `Driver` 클래스의 코드 수정이 필요 없음
- `Car` 인터페이스를 구현하여 새로운 자동차를 계속해서 추가 가능

## OCP(Open-Closed Principle) 원칙
- Open for extension: 새로운 기능의 추가나 변경 사항이 생겼을 때, 기존 코드는 확장할 수 있어야 한다.
- Closed for modification: 기존의 코드는 수정되지 않아야 한다.
- 기존 코드 수정을 최소화하면서 새로운 기능을 추가할 수 있는 것