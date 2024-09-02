# 중첩 클래스, 내부 클래스1
## 중첩 클래스(Nested Class)
- 클래스 내부에 정의된 다른 클래스
- 종류
  - 정적 중첩 클래스 (Static Nested Class)
  - 내부 클래스
    - 내부 클래스 (Inner Class)
    - 지역 클래스 (Local Class)
    - 익명 클래스 (Anonymous Class)
- 특정 클래스가 하나의 클래스에서만 사용되거나 바깥 클래스와 논리적으로 밀접하게 관련된 클래스를 구현할 때 사용
- 외부에 노출될 필요가 없는 내부 구현을 감추고, 특정 기능을 바깥 클래스와 함께 관리하여 모듈성을 높이기 위해 사용
## 정적 중첩 클래스
- 바깥 클래스의 정적 멤버와 클래스 멤버에 접근 가능
- 바깥 클래스의 인스턴스와는 독립적으로 존재할 수 있어, 필요하지 않은 인스턴스 생성을 방지
- 바깥 클래스의 정적 멤버와 관련된 로직을 처리하는 클래스를 정의할 때 사용
```java
public class Car {
    private static String model = "Avante";

    // 정적 중첩 클래스
    public static class Engine {
        private String type;

        public Engine(String type) {
            this.type = type;
        }

        // 자동차의 정보 출력
        public void print() {
            System.out.println("Model: " + model);
            System.out.println("Type: " + type);
        }
    }

    public static void main(String[] args) {
        // 정적 중첩 클래스의 인스턴스 생성
        Engine engine = new Engine("Gasoline");
        engine.print();
    }
}
```
## 내부 클래스
- 바깥 클래스의 인스턴스 멤버와 클래스 멤버에 접근 가능
- 바깥 클래스의 인스턴스를 이루는 요소
- 필요한 메서드만 외부에 노출함으로써 캡슐화 달성
```java
public class Car {
    private String maker;
    private String model;

    // 내부 클래스
    public class Engine {
        private String type;

        public Engine(String type) {
            this.type = type;
        }

        // 차의 정보를 출력하는 메서드
        public void print() {
            // 외부 클래스의 인스턴스 멤버에 접근 가능
            System.out.println("Car Maker: " + maker);
            System.out.println("Car Model: " + model);
            System.out.println("Type: " + type);
        }
    }
    
    public Car(String maker, String model) {
        this.maker = maker;
        this.model = model;
    }

    public static void main(String[] args) {
        // 바깥 클래스의 인스턴스 생성
        Car car = new Car("KIA", "K9");

        // 내부 클래스의 인스턴스 생성
        Car.Engine engine = car.new Engine("Gasoline");

        // 내부 클래스의 메서드 호출
        engine.print();
    }
}
```