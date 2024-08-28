# 제네릭2

## 타입 파라미터 제한
- `extends` 키워드를 사용해 타입 파라미터로 들어올 수 있는 타입의 상한을 제한할 수 있음
- `extends` 키워드를 사용하면 상한 타입의 메서드를 제네릭 타입 내부에서 사용할 수 있음

<br>

## 제네릭 메서드
- 제네릭 메서드의 타입 파라미터는 코드 상에서 제네릭 메서드를 호출할 때 결정됨
- 즉, 마찬가지로 제네릭 메서드의 타입 파라미터는 컴파일 타임에 결정되며, 런타임에는 type erasure가 일어남

<br>

## 와일드카드
- 제네릭을 활용하기 위한 기능(주의: 제네릭을 정의할 때 사용할 수 없음)

### 종류
- Unbounded(`<?>`): 모든 타입을 받을 수 있음(`<? extends Object>`와 동일)
- Upper bounded(`<? extends T>`): 제네릭 타입이 T이거나 T의 자식 타입이어야 함
- Lower bounded(`<? super T>`): 제네릭 타입이 T이거나 T의 부모 타입이어야 함

### 제네릭 메서드 vs 와일드카드
- 제네릭 와일드카드를 사용할 수 없는 경우에만 제네릭 메서드를 정의하는 것을 권장
- 즉, 타입 파라미터로 전달한 타입을 명확하게 반환하고 싶은 경우에만 제네릭 메서드 사용

```java
// 제네릭: 명확한 Dog 타입 리턴
public <T extends Animal> T foo(Box<T> box) { ... }
Dog dog = foo(new Box<Dog>());

// 와일드카드: Animal 타입 리턴
public Animal boo(Box<? extends Animal> box) { ... }
Animal animal = boo(new Box<Dog>());
```

<br>

## Type Erasure
- 제네릭 타입 정보가 컴파일 타임에만 유효하고 런타임에는 제거되는 특성
- 런타임(`.class` 파일)에는 제네릭 타입 정보가 제거되어 `Object` 타입으로 변환됨(바운드가 있다면 해당 바운드 타입으로 변환)
- 따라서 런타임에 제네릭 타입을 인스턴스화하거나, 제네릭 타입에 대해 `instanceof` 연산을 수행하는 등의 코드는 작성할 수 없음
- Type erasure는 제네릭 등장 이전 자바와의 하위 호환성을 유지하기 위해 설계됨 

```java
// 컴파일 전
public class Box<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// 컴파일 후
public class Box {
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
```