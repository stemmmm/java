# 다양한 클래스

## 래퍼 클래스

- 필요성: 기본형만으로는 한계 존재
  1. 객체가 아님: 객체로만 사용할 수 있는 제네릭이나 컬렉션 프레임워크 사용 불가, 추가 기능을 제공하는 메서드 없음
  2. `null` 값을 가질 수 없음: 값이 없음을 표현할 수 없어 항상 값을 가져야함
- 위와 같은 상황에서는 기본형을 클래스로 감싼 래퍼 클래스를 사용하면 됨
- 래퍼 클래스는 불변 객체이며, 객체이므로 `equals` 메서드로 동등성을 비교해야함
- 래퍼 클래스는 기본형에 비해 많은 편의 기능을 제공하지만, 객체이므로 성능이 떨어지고 더 많은 메모리 공간을 필요로함

### 박싱과 언박싱

- 기본형을 래퍼 클래스로 변경하는 과정을 박싱(boxing)이라 부름
- 반대로, 래퍼 클래스의 값을 기본형으로 변경하는 과정을 언박싱(unboxing)이라 부름
- 하지만 개발자가 매번 직접 박싱과 언박싱을 하는 것은 매우 불편하므로 자바에서는 오토 박싱/언박싱을 지원함
- 오토 박싱/언박싱은 컴파일러가 개발자 대신 `valueOf`, `xxxValue()` 등의 코드를 추가해주는 기능임 

### `parseXXX` vs `valueOf`

- `parseXXX` 메서드는 문자열을 받아 기본형을 반환
- `valueOf` 메서드는 래퍼 타입 반환

```java
int parseInt = Integer.parseInt("10");
Integer valueOfString = Integer.valueOf("10");
Integer valueOfInt = Integer.valueOf(10);  // Integer valueOfInt = 10;과 동일 
```

<br>

## `Class` 클래스

- 클래스의 메타데이터가 저장된 클래스
- 즉, `Class` 클래스를 통해 개발자는 런타임에 클래스의 속성과 메서드에 대한 정보를 조회하고 조작할 수 있음

### 주요 기능
- 타입 정보 조회: 클래스 이름, 상속한 클래스나 인터페이스 등
- 리플렉션: 클래스에 정의된 필드, 메서드 조회 및 호출
  - e.g. `Class.forName()` 메서드를 사용해 클래스 동적 로드 및 `newInstance()` 메서드로 새로운 인스턴스 생성
- 어노테이션 처리: 클래스에 정의된 어노테이션 조회 및 처리

<br>

## `System` 클래스

- 시스템과 관련된 기본 기능을 제공하는 클래스

### 주요 메서드
- `System.in`, `System.out`, `System.err`: 표준 입출력, 에러 스트림
- `System.currentTimeMillis()`, `System.nanoTime()`: 현재 시간 제공
- `System.getenv()`: OS 환경 변수 조회
- `System.getProperties()`: JVM 시스템 속성 조회
- `System.exit(int status)`: exit code와 함께 프로그램 종료
- `System.arraycopy`: 배열 고속 복사