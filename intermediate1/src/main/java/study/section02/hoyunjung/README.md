# 불변 객체

- 정의: 상태(내부 값)가 변하지 않는 객체
- 객체를 불변으로 설계하면 사이드 이펙트를 막을 수 있음
- 값을 변경하면 안되는 특별한 경우에 사용(대부분의 경우 가변 클래스 사용)

```java
import lombok.Getter;

@Getter
public class Immutable {
    private final int value;

    public Immutable(int value) {
        this.value = value;
    }

    // 불변 객체이지만 값을 변경하는 메서드가 필요할때
    public Immutable add(int value) {
        return new Immutable(this.value + value);
    }
}

public class Main {
    public static void main(String[] args) {
        Immutable obj = new Immutable(10);
        Immutable addedObj = obj.add(10);

        System.out.println(obj.getValue());       // 10 출력
        System.out.println(addedObj.getValue());  // 20 출력
    }
}
```

> **참고**  
> 불변 객체에서 값을 변경하는 메서드의 이름은 `with`로 시작하는 경우가 많으며, 이는 메서드가 지정된 변경사항을 포함하는 새로운 인스턴스를 반환한다는 사실을 의미함

## 클래스를 불변으로 설계하는 이유

1. 캐시 안정성: 객체의 상태가 변하지 않으므로 캐시를 적극적으로 사용할 수 있음
2. 쓰레드 안정성: 객체의 상태가 변하지 않으므로 여러 쓰레드에서 동시 접근 가능
3. 엔티티의 값 타입:  값 타입은 객체가 동일한 상태를 가지면 동일한 값으로 취급하므로 비교나 복사에 용이(e.g. `String`, `Integer`)