# 래퍼(Wrapper), Class 클래스
## 래퍼 클래스
- 필요성
  - 기본형의 한계
  - 기본형 데이터 타입은 객체가 아님
    - 래퍼 클래스는 기본형 데이터를 객체로 감싸서, 객체 지향 프로그래밍의 이점 활용 가능
  - null 값 지원
    - 기본형 데이터 타입은 항상 값을 가지기 때문에 null 값을 가질 수 없는 데에 반해, 객체인 래퍼 클래스는 null 값을 할당 가능
    - 데이터가 아직 초기화되지 않았거나, 값이 존재하지 않을 때 유용하게 사용 가능
- 불변 객체이며, `equals`로 동등성 비교
## 박싱(Boxing), 언박싱(Unboxing)
- 박싱: 기본형을 래퍼 클래스로 변경 → `valueOf()`
- 언박싱: 래퍼 클래스의 객체를 기본형으로 변경 → `intValue()`, `doubleValue()` 등
- 박싱과 언박싱을 하는 일이 자주 있기 때문에, 자바에서 오토박싱/언박싱 지원, 컴파일러가 자동으로 처리
- `parseInt`: String을 int로 변환
  - `int num = Integer.parseInt("123");`
- `valueOf`: String을 Integer 객체로 변환
  - `Integer num = Integer.valueOf("123");`
## Class 클래스
- 클래스의 메타정보를 제공하는 클래스
- 런타임에 클래스에 대한 정보를 얻거나 조작 가능
- 주요 기능
  - 타입 정보 얻기: 클래스의 이름, 슈퍼클래스, 인터페이스 정보 조회
  - 리플렉션: 클래스에 정의된 메서드, 필드, 생성자 등을 조회, 객체 인스턴스를 생성하거나 메서드를 호출
  - 동적 로딩과 생성: `Class.forName()`로 클래스를 동적 로드, `newInstance()`로 새로운 인스턴스 생성
  - 애노테이션(annotation) 처리: 클래스에 적용된 애노테이션을 조회 및 처리
## System 클래스
- `java.lang` 패키지에 포함된 유틸리티 클래스. 이 클래스는 시스템과 관련된 기본 기능들을 제공
- 주요 기능
  - 표준 입력, 출력, 오류 스트림: `System.in`, `System.out`, `System.err`
  - 시간 측정: `System.currentTimeMillis()`, `System.nanoTime()`
  - 환경 변수: `System.getenv(String name)`
  - 시스템 속성: `System.getProperty(String key)`
  - 시스템 종료: `System.exit(int status)`
  - 배열 고속 복사: `System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`