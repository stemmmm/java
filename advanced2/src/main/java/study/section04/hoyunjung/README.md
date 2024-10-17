# IO 활용

## 코드 

### 설명
IO에 대한 이해를 돕기 위한 회원 관리 예제

### 발전 순서
1. `MemoryMemberRepository`: 메모리에 데이터 저장
2. `FileMemberRepository`: 파일에 데이터 저장
3. `DataMemberRepository`: `DataStream`을 사용하여 타입 변환 없이 간편하게 저장
4. `ObjectMemberRepository`:`ObjectStream`으로 객체를 직렬화하여 더욱 간편하게 저장

<br>

## 데이터 교환 방식

### 직렬화(Serialization)  
- 메모리에 있는 객체를 바이트 스트림으로 변환하여 파일에 저장하거나 네트워크로 전송이 가능하게 하는 기술
- 역직렬화(Deserialization)를 통해 바이트 스트림을 다시 원래 객체로 복원 가능
- 직렬화하려는 클래스는 반드시 `Serializable` 인터페이스를 구현해야 함
- 현재는 버전 관리의 어려움, 플랫폼 종속성, 느린 성능 등의 이유로 직렬화 기술은 거의 사용되지 않음

### XML(Extensible Markup Language)
- 유연하지만 복잡하고 무거움
- 태그를 포함한 XML 문서의 크기가 크므로 네트워크 전송 비용이 큼

```xml
<member>
    <id>id1</id>
    <name>name1</name>
    <age>20</age>
</member>
```

### JSON(JavaScript Object Notation)
- 가볍고 간결하며 자바스크립트와의 호환성 덕분에 웹 개발에서 널리 사용됨
- 사람이 읽고 쓰기 쉬운 텍스트 기반 포맷이어서 디버깅과 개발이 쉬움
- 2000년대 후반 웹 API와 RESTful 서비스가 대중화되면서 JSON은 표준 데이터 교환 포맷이 됨

```json
{
  "member": {
    "id": "id1",
    "name": "name1",
    "age": 20
  }
}
```

### Protobuf, Avro
- 매우 작은 용량으로 빠른 속도를 제공하는 바이트 기반 포맷
- 다만 바이트 기반이므로 JSON처럼 사람이 직접 읽기는 어려우며 호환성도 떨어짐