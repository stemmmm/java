# 열거형 - ENUM
## Type-safe Enum Pattern
- 타입 안전성을 강화하는 패턴
  - 타입 안전성: 열거형 상수를 클래스의 상수로 정의하여 잘못된 상수 값이 사용되는 것을 방지
- enum 타입이 도입되기 전에 열거형 상수를 구현하기 위해 사용
- 열거형에 메서드 등을 추가해 상수와 관련된 동작 정의 가능
```java
public class Color {
    public static final Color RED = new Color("Red");
    public static final Color GREEN = new Color("Green");
    public static final Color BLUE = new Color("Blue");

    private final String color;

    private Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

public class ColorMain {
    public static void main(String[] args) {
        Color color = Color.RED;
        Color color = Color.GREEN;
        Color color = Color.BLUE;

        System.out.println("color = " + color);
    }
}
```
## 열거형
- 간결성: 상수와 관련된 모든 것을 한 곳에서 관리 가능
- 타입 안전성: 열거형은 컴파일 타임에 타입을 체크하므로, 잘못된 상수 사용을 방지
- 추가 기능: 열거형에 메서드와 필드를 추가하여 상수와 관련된 추가 정보를 저장하거나 동작 정의
- 위 코드를 열거형으로 구현
```java
public enum Color {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

public class ColorMain {
    public static void main(String[] args) {
        Color color1 = Color.RED;
        Color color2 = Color.GREEN;
        Color color3 = Color.BLUE;


        System.out.println("color1 = " + color1.getColor());
        System.out.println("color2 = " + color2.getColor());
        System.out.println("color3 = " + color3.getColor());
    }
}
```
