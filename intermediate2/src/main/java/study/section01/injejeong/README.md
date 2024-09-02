# 제네릭1
## 제네릭의 필요성
- 타입 안정성: 컴파일 타임에 타입 검사 가능
  - 런타임에서 발생할 수 있는 타입 오류 예방
- 코드 재사용성: 동일한 코드를 다양한 타입으로 재사용 가능
- 타입 캐스팅 방지: 객체를 꺼낼 때 별도로 다운 캐스팅을 하지 않아도 됨
```java
public class GenericBox<T> {
    // 저장할 객체의 타입 지정
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```
## 제네릭의 핵심 - 사용할 타입을 미리 결정하지 않는다
- 생성 시점에 타입을 결정하기 때문에 특정 클래스나 메서드가 다양한 타입을 처리할 수 있게 함
- 타입 매개변수에 타입 인자를 전달해서 사용할 타입을 결정
  - 제네릭의 타입 인자로 기본형(`int`, `double` 등) 사용 불가
  - 대신에 래퍼 클래스(`Integer`, `Double`) 사용
## 로 타입(Raw Type)
- 제네릭을 사용하기 전의 자바 버전에서 사용하던 방식
- `<>`로 타입을 지정하지 않음
- 타입 파라미터가 없는 제네릭 클래스나 메서드
- 타입 매개변수로 `Object`가 사용됨
- 타입 안전성이 보장되지 않으며, 타입 캐스팅을 명시적으로 수행해야 하므로 사용 지양
```java
class RawType {
    private Object value;
    
    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}

public class RawTypeMain {
    public static void main(String[] args) {
        // Raw Type
        Box box = new Box();
        box.setValue("Hello");
        String str = (String) box.getValue(); // 타입 캐스팅 필요

        box.setValue(123); // 정수를 저장 시 오류 발생
    }
}
```
