# 제네릭2
## 타입 매개변수 제한
- 제네릭 타입을 선언하면 컴파일러는 `T`가 어떤 타입일지 예상 불가
- 따라서 어떤 타입이든 받을 수 있는 최상위 부모인 `Object` 타입으로 가정
- 이 때 전혀 관계 없는 타입을 타입 인자로 전달 가능
- 타입 매개변수 상한을 통해 타입 안전성을 지키면서 상위 타입의 원하는 기능까지 사용 가능
- `extends` 키워드 사용
```java
public class Box<T extends Number> { // T는 Number의 하위 타입이어야 한다
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```
## 제네릭 메서드
- 특정 메서드 단위로 제네릭을 도입할 때 사용
- 메서드를 실제 호출하는 시점에 타입 결정 후 메서드 호출
```java
public class GenericMethod {
    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();

        genericMethod.print("Hello, World!");
        genericMethod.print(123);
        genericMethod.print(45.67);
    }
    
    // 제네릭 메서드: 어떤 타입이든 받아서 출력
    public <T> void print(T value) {
        System.out.println(value);
    }

}
```
## 와일드카드(Wildcard)
- `*` , `?`와 같이 하나 이상의 문자들을 상징하는 특수 문자
- 이미 만들어진 제네릭 타입을 활용할 때 사용
- 특정 상황에 맞게 제네릭 타입의 범위 조절 가능
- 종류
  - 비제한 와일드카드 - `?`
    - 제한 없이 모든 타입을 다 받을 수 있음
  - 상한 와일드카드 - `? extends T`
    - 제네릭 타입 매개변수가 `T` 혹은 하위 타입이어야 함
  - 하한 와일드카드 - `? super T`
    - 제네릭 타입 매개변수가 `T` 혹은 상위 타입이어야 함
- 제네릭 타입이나 제네릭 메서드를 정의하는게 꼭 필요한 상황이 아니라면, 더 단순한 와일드카드 사용
## 타입 이레이저(Type Erasure)
- 컴파일 이후에 제네릭의 타입 정보가 제거되는 과정
- 런타임에는 원래의 타입 정보가 사라지는데, 이 과정에서 제네릭 타입의 매개변수는 상위 타입으로 대체됨
- 런타임에 타입을 활용하는 `instanceof` 혹은 `new` 사용 불가
```java
// 컴파일 전
public class BeforeTypeErasure<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

// 컴파일 후
public class AfterTypeErasure {
    private Object value;

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
```