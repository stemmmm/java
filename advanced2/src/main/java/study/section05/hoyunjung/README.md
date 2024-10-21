# `File`, `Files`

## `File`
- 파일이나 디렉토리를 생성할 수 있음
- `File` 객체를 생성했다고 파일이나 디렉토리가 생성되는 것이 아니며, 메서드를 통해 생성해야함

## `Files`
- 자바 1.7에서 `File` 클래스를 대체하기 위해 성능과 편의성이 모두 개선된 `Files`와 `Path`가 등장함
- 따라서 파일을 다루어야 할 일이 있다면, `File`이나 파일 관련 스트림 사용보다 `Files` 사용을 우선적으로 고려해야함

## 경로

### 절대 경로(Absolute Path)
- 파일 시스템의 루트부터 시작하는 전체 경로
- e.g. `/home/user/documents/file.txt`

### 정규 경로(Canonical Path)
- 파일 시스템 내에서 파일이나 디렉토리의 고유한 경로
- 심볼릭 링크가 포함된 경로는 그 링크를 해석하여 실제 경로를 반환함
- e.g. `/home/user/../user2/documents/./file.txt`의 정규 경로: `/home/user2/documents/file.txt`