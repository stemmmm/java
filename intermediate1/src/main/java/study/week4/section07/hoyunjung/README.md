# 중첩 클래스, 내부 클래스1
- 중첩(Nested) 클래스: 코드 위치만 외부 클래스 내에 존재, 즉 외부 클래스의 인스턴스와는 무관
- 내부(Inner) 클래스: 코드 위치뿐만 아니라 외부 클래스 인스턴스에 대한 참조를 가짐, 따라서 외부 클래스보다 먼저 생성 불가
- 두 클래스가 의미론적으로 긴밀하게 연관되어 있고, 하나의 클래스가 다른 클래스 내에서만 사용되는 경우 사용

### 분류
1. 정적(static) 중첩 클래스
2. 내부 클래스(non-static)
   - 내부(inner) 클래스
   - 로컬(local) 클래스: 지역 변수처럼 로컬 스코프에서 클래스 정의
   - 익명(anonymous) 클래스: 이름 없는 로컬 클래스

```java
class OuterClass {
    // 정적 중첩 클래스
    static class NestedStaticClass {
    }

    // 내부 클래스
    class InnerClass {
    }

    public void foo() {
        // 로컬 클래스
        class LocalClass {
        }
    }
}
```