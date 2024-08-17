# 날짜와 시간
## 날짜와 시간 라이브러리의 필요성
- 두 날짜 사이의 정확한 일수 계산은 윤년, 일광 절약 시간(써머 타임), 타임존을 고려해야하기 때문에 매우 복잡하다
## 날짜와 시간을 다루는 클래스 / 열거형
- 모든 날짜 클래스는 불변이기 때문에, 변경해야할 경우 새로운 객체를 생성해서 반환값을 받아야 한다.
- 기본 날짜와 시간
    - 세계 시간대를 고려하지 않고 특정 지역의 날짜와 시간만을 고려할 때 사용하기 때문에 `Local`이 붙는다
    - `LocalDate`: 날짜만 표현할 때 사용, 년, 월, 일을 다룬다.
    - - `LocalTime`: 시간만 표현할 때 사용, 시, 분, 초를 다룬다.
    - 초는 밀리초, 나노초 단위도 포함할 수 있다.
    - `LocalDateTime`: `LocalDate` 와 `LocalTime` 을 합한 개념
    - `.now()`, `.of()`, `.plusXXX()`(`Day`, `Week`, `Seconds` 등), `isXXX()`(`Before`, `After`, `Equal`)  사용 가능
```java
// 현재
LocalDate today = LocalDate.now();
LocalTime now = LocalTime.now();
LocalDateTime nowdt = LocalDateTime.now();

// 특정
LocalDate ofDate = LocalDate.of(2024, 8, 17);
LocalTime ofTime = LocalTime.of(20, 47);
LocalDateTime ofDateTime = LocalDateTime.of(2024, 8, 17, 20, 47);

// 날짜 연산
LocalDate nextWeek = today.plusWeeks(1);
LocalTime nextHour = now.plusHours(1);

// 날짜 비교
boolean isBefore = ofDate.isBefore(today);
```
- `ZonedDateTime`: 시간대를 고려한 날짜와 시간을 표현할 때 사용, 시간대를 표현하는 타임존이 포함되어 일광 시간 절약제 처리 가능
    - `ZoneId.systemDefault()` : 시스템이 사용하는 기본 `ZoneId` 반환
    - `ZoneId.of()` : 타임존을 직접 제공하여 `ZoneId` 반환
    - `withZoneSameInstant(ZoneId)`: 타임존 변경
    - `now()`, `of()` 사용 가능
```java
// 시스템의 기본 타임존 반환
ZoneId zoneId = ZoneId.systemDefault();

// 시스템 기본 타임존으로 현재 날짜와 시간 반환
ZonedDateTime nowZDT = ZonedDateTime.now();

// 시스템 기본 타임존으로 특정 날짜와 시간 생성
ZonedDateTime ofZDT = ZonedDateTime.of(2024, 8, 17, 21, 11, 0, 0, zoneId);
```
- `OffsetDateTime`: 시간대를 고려한 날짜와 시간을 표현할 때 사용, 타임존 미포함, UTC(협정 세계시)로 부터의 시간대 차이인 고정된 오프셋만 포함
```java
// 현재 날짜와 시간, 시스템 기본 오프셋으로 OffsetDateTime 반환
OffsetDateTime now = OffsetDateTime.now();

// 특정 날짜와 시간, 오프셋을 지정하여 OffsetDateTime 생성
OffsetDateTime specificDateTime = OffsetDateTime.of(2024, 8, 17, 21, 11, 0, 0, ZoneOffset.of("+01:00"));
```
- `Instant`: UTC를 기준으로 하는 시간의 한 지점
    - 날짜와 시간을 나노초 정밀도로 표현하며, 1970년 1월 1일 0시 0분 0초(UTC)를 기준으로 경과한 시간 계산
    - 장점: 시간대에 영향을 받지 않고, 동일 시점 가리키는 데 유용하며, 일관된 시간 계산 및 비교 가능
    - 단점: 사람이 사용하기엔 부적합하며, 특정 지역의 날짜와 시간으로 변환하는 데에 추가 작업 필요
- `now()`, `from()`, `ofEpochSecond()`, `plusSeconds()`, `getEpochSecond()` 사용 가능
```java
 // 현재 시각을 Instant 객체로 반환
Instant now = Instant.now();

// 현재 시각의 Epoch Second 반환
long nowEpochSecond = now.getEpochSecond();

// Epoch Second를 이용해 새로운 Instant 객체 생성
Instant fromEpochSecond = Instant.ofEpochSecond(nowEpochSecond);

// 초 추가
Instant plusSeconds = now.plusSeconds(3600);
```
- `Period`: 두 날짜 사이의 간격을 년, 월, 일 단위로 나타낸다.
```java
LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(2001, 1, 28);

// 오늘과 생일 간의 Period 계산하기
Period age = Period.between(birthday, today);
```
- `Duration`: 두 시간 사이의 간격을 시, 분, 초(나노초) 단위로 나타낸다
```java
LocalTime start = LocalTime.of(11, 22);
LocalTime end = LocalTime.of(11, 44);
// 두 LocalTime 간의 duration 계산
Duration timeDifference = Duration.between(start, end);
```
## 시간의 단위
- `TemporalUnit`: 날짜와 시간 측정 단위 제공
- `ChronoUnit`: 시간 단위 제공
## 시간 필드
- `ChronoField`: 날짜와 시간의 특정 부분을 나타내는 열거형
- `TemproalField`: 날짜와 시간을 나타내는데 사용되는 인터페이스
## 날짜와 시간 조회 / 조작하기
- `Temporal` 인터페이스 사용
- `TemporalAccessor`: 특정 시점의 시간 조회
- `plus()`, `with()`을 통해 시간 조작 가능
- `TemporalAdjusters`: 복잡한 시간 계산 가능
## 날짜와 시간 문자열 파싱과 포맷팅
- 파싱(parsing): 문자열을 날짜와 시간 객체로 변경
- 포맷팅(formatting): 날짜와 시간 데이터를 원하는 포맷의 문자열로 변경
- `DateTimeFormatter` 사용