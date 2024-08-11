# 열거형(Enum)

## Type-Safe Enum 패턴

- 열거형은 type-safe enum 패턴으로 만들어진 클래스임
- Type-safe enum 패턴을 사용하면 타입 안전성이 향상되어 잘못된 값을 입력받는 문제를 해결할 수 있음

```java
public class DangerLevel {
    public static final DangerLevel SAFE = new DangerLevel(10);
    public static final DangerLevel WARNING = new DangerLevel(20);
    public static final DangerLevel CAUTION = new DangerLevel(30);
    public static final DangerLevel DANGER = new DangerLevel(40);
    
    private final int upperBound;
    
    private DangerLevel(int upperBound) {}  // 외부에서 인스턴스 생성 불가

    public int getUpperBound() {
        return upperBound;
    }
}
```

## 열거형(Enum)

- 아래 코드는 위 type-safe enum 패턴으로 구현한 클래스와 동일한 동작을 하는 열거형임 

```java
public enum DangerLevel {
    SAFE(10), WARNING(20), CAUTION(30), DANGER(40);
    
    private final int upperBound;
    
    // 생성자는 private으로만 선언 가능(생략하여 표기)
    DangerLevel(int upperBound) {
        this.upperBound = upperBound;
    }

    public int getUpperBound() {
        return upperBound;
    }
}
```

### 내부 구현

- 열거형은 내부적으로 `java.lang.Enum`을 상속받아 구현되는 클래스이므로 다른 클래스를 상속받을 수 없음
- 인터페이스를 상속(구현)할 수 있음
- 추상 메서드를 선언 및 구현할 수 있음

```java
public class DangerLevel extends Enum {
    public static final DangerLevel SAFE = new DangerLevel();
    public static final DangerLevel WARNING = new DangerLevel();
    public static final DangerLevel CAUTION = new DangerLevel();
    public static final DangerLevel DANGER = new DangerLevel();

    private DangerLevel() {}
}
```