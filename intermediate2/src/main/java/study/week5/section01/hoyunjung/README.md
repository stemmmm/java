# 제네릭1

## 제네릭의 필요성
- `Object`를 통해 다형성을 활용할 수 있지만, 타입 안전성이 떨어지는 문제가 있음
- 제네릭을 사용하면 다형성과 타입 안전성을 동시에 챙길 수 있음

```java
public class GenericClass<T> {
    private T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

<br>

## 제네릭 타입이 결정되는 시점
- 제네릭 타입 파라미터는 컴파일 타임에 결정되며, 런타임에는 type erasure가 일어남
- 따라서 제네릭을 사용하면 컴파일 타임에 타입 체크가 가능함

<br>

## Raw type
- 타입 파라미터를 사용하지 않는 클래스를 raw type이라 부름
- 제네릭이 도입되기 이전에 사용하던 방식(지금은 하위호환성을 위해 존재)
- 타입 안전성을 보장받지 못하므로 사용 지양

```java
// 제네릭
List<Integer> list = new ArrayList<>();

// Raw type
List list = new ArrayList();
```