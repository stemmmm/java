# 날짜와 시간

## 시간대
- GMT(Greenwich Mean Time): 그리니치 천문대를 기준으로 하는 시간대, 태양이 그리니치 천문대를 통과하는 시간을 정오로 함
- UTC(Universal Time Coordinated): 그리니치 천문대를 기준으로 하는 시간대, 원자 시계 기반이라 GMT보다 정밀, 현재 국제 표준
- KST(Korea Standard Time): 한국 표준시(UTC+9 시간대)

<br>

## 날짜와 시간 라이브러리

### `Local` 시리즈
- 타임존 없이 날짜와 시간 정보를 표현
- 따라서 글로벌 서비스의 경우 `Local` 시리즈를 사용하면 안됨
- `LocalDate`: 날짜(년, 월, 일) 정보만 필요할 때 사용하는 클래스
- `LocalTime`: 시간(시, 분, 초) 정보만 필요할 때 사용하는 클래스
- `LocalDateTime`: 날짜와 시간 정보 모두 필요할 때 사용하는 클래스(내부적으로 `LocalDate`와 `LocalTime`을 가짐) 

### `OffsetDateTime`
- 오프셋(UTC와의 시간 차이)이 포함된 날짜와 시간 정보를 표현
  - e.g. UTC+09:00: UTC보다 9시간 빠른 시간대, UTC-05:00: UTC보다 5시간 느린 시간대
- `ZoneOffset`: 오프셋 정보를 담고있는 클래스
- `OffsetDateTime`: 내부적으로 `LocalDateTime`, `ZoneOffset`을 가지는 클래스

### `ZonedDateTime`
- 타임존, 오프셋이 포함된 날짜와 시간 정보를 표현
- `ZoneId`: 타임존 정보를 담고있는 클래스
- `ZonedDateTime`: 내부적으로 `LocalDateTime`, `ZoneOffset`, `ZoneId`를 가지는 클래스 

### 정리

```text
|---------------------ZonedDateTime---------------------|
|--------------OffsetDateTime--------------|
|-------LocalDateTime-------|
|--LocalDate--|--LocalTime--|--ZoneOffset--|---ZoneId---|
   2024-08-13    09:00:00        +09:00       Asia/Seoul
```

<br>

### 기타
- `Instant`: Epoch 시간(Unix 시간)이 담긴 클래스
- `Duration`: 두 시간 사이의 간격을 시, 분, 초, 나노초 단위로 나타냄
- `Period`: 두 날짜 사이의 간격을 년, 월, 일 단위로 나타냄

<br>

## 날짜와 시간 인터페이스

### 시각과 기간
- 시간은 시각과 기간으로 분류할 수 있음

#### 시각
- 시각은 특정 시점의 시간을 의미함
- `TemporalAccessor` 인터페이스를 상속한 `Temporal` 인터페이스 구현
- `TemporalAccessor` 인터페이스는 읽기 기능 제공, `Temporal` 인터페이스는 쓰기 기능 제공
- 구현체: `LocalDateTime`, `OffsetDateTime`, `ZonedDateTime`, `Instant` 등

#### 기간
- 기간은 시각과 시각 사이의 간격을 의미함
- `TemporalAmount` 인터페이스 구현
- 구현체: `Period`, `Duration`

### 단위와 필드
- 시간은 단위(unit)와 필드(field)로 이루어짐
- 주로 날짜와 시간을 조회하거나 조작하는데 사용

#### 단위
- 단위는 시간을 측정하는 기준을 의미함
- `TemporalUnit` 인터페이스의 구현체인 `ChronoUnit` 열거형을 주로 사용
- `ChronoUnit` 열거형에는 `SECONDS`, `MINUTES`, `HOURS`, `DAYS`, `WEEKS`, `MONTHS`, `YEARS` 등이 정의돼있음

#### 필드
- 필드는 시간을 이루는 특정 부분을 의미함
- `TemporalField` 인터페이스의 구현체인 `ChronoField` 열거형을 주로 사용
- `ChronoField` 열거형에는 `YEAR`, `MONTH_OF_YEAR`, `DAY_OF_WEEK`, `DAY_OF_MONTH` 등이 정의돼있음

<br>

## 파싱과 포맷팅
- 파싱(parsing): 원시 데이터(e.g. 문자열)를 구조화된 형태(e.g. 객체)로 변환하는 과정
- 포맷팅(formatting): 구조화된 데이터(e.g. 객체)를 사람이 이해하기 쉬운 형태(e.g. 문자열)로 변환하는 과정

### 날짜와 시간의 파싱과 포맷팅
- 파싱: 문자열을 날짜와 시간 객체로 변환하는 과정
- 포맷팅: 날짜와 시간 객체를 원하는 형태의 문자열로 변환하는 과정
- `DateTimeFormatter` 사용