# 애노테이션

## 개념
- 코드에 부가적인 정보를 제공하는 데 사용되는 메타데이터
- 컴파일러에 특정 지시를 내리거나 런타임 프로그램 동작에 영향을 줄 수 있음

<br>

## 정의
- `@interface` 키워드를 사용하여 정의
- 애노테이션의 요소는 매개변수가 없는 메서드 형태로 정의되며, 다음 타입만 허용됨:
  - 기본 타입, `String`, `enum`, 클래스 타입(`Class`), 다른 어노테이션, 배열
  - `void` 타입 및 커스텀 클래스 타입은 사용할 수 없음
- `default` 키워드를 사용해 요소에 기본값을 설정할 수 있음
- 요소는 예외를 선언하거나 던질 수 없음
- 애노테이션에 요소가 하나만 있고 그 이름이 `value`인 경우에 한하여, 애노테이션 사용 시 `value`라는 요소 이름을 생략할 수 있음 

```java
import study.util.MyLogger;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoElement {

    String value();

    int count() default 0;

    String[] tags() default {};

    Class<? extends MyLogger> annoData() default MyLogger.class;
}
```

<br>

## 메타 애노테이션
- 애노테이션을 정의하는데 사용하는 애노테이션

### 종류
- `@Retention`: 애노테이션의 생존 시간 지정
  - `RetentionPolicy.SOURCE`: 소스 코드에만 존재, 컴파일 시 제거됨
  - `RetentionPolicy.CLASS`: (기본 값) 컴파일 후 `.class` 파일까지 유지되지만, 런타임에 제거됨
  - `RetentionPolicy.RUNTIME`: (일반적으로 사용) 런타임까지 유지되어 리플렉션을 통해 애노테이션 정보를 읽을 수 있음
- `@Target`: 애노테이션을 사용할 수 있는 위치 지정(주로 `TYPE`, `FIELD`, `METHOD` 등 사용)
- `@Documented`: Javadoc 생성 시 해당 애노테이션 정보를 포함할지 지정
- `@Inherited`: 부모 클래스에 정의된 애노테이션을 자식 클래스가 상속받을 수 있도록 지정(클래스 상속에서만 작동, 인터페이스에서는 X)

<br>

## 상속
- 모든 애노테이션은 `java.lang.annotation.Annotation` 인터페이스를 묵시적으로 상속받음
- 애노테이션은 특별한 형태의 인터페이스로, 다른 애노테이션이나 인터페이스를 직접 상속할 수 없음

```java
package java.lang.annotation;

public interface Annotation {
    boolean equals(Object obj);
    int hashCode();
    String toString();
    Class<? extends Annotation> annotationType();
}
```

<br>

## 자바 표준 어노테이션
- `@Overrride`: 메서드가 부모 클래스나 인터페이스의 메서드를 올바르게 오버라이딩 했는지 컴파일러가 확인하기 위해 사용
- `@Deprecated`: 더 이상 사용을 권장하지 않는 요소임을 표시하기 위해 사용
- `@SuppressWarnings`: 특정 컴파일 경고를 무시하기 위해 사용