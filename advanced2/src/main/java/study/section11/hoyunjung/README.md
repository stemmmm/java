# HTTP 서버 만들기

## URL 인코딩
- HTPP 메시지 시작 라인(URL 포함)과 헤더 이름은 하위 호환성을 위해 ASCII를 사용해야하며, UTF-8 등의 다른 인코딩 방식은 지원하지 않음
- 따라서 ASCII 이외의 문자가 포함되면 퍼센트(%) 인코딩을 사용하여 전달함
- 자바에서 제공하는 `URLEncoder.encode()`와 `URLDecoder.decode()`를 사용하여 퍼센트 인코딩을 처리할 수 있음
- HTTP 바디는 `Content-Type` 헤더에 따라 UTF-8과 같은 다른 인코딩 방식을 사용할 수 있음