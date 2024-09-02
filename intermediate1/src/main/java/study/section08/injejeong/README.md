## 지역 클래스
- 메서드 내부에서 정의되며, 지역 변수에 접근 가능
```java
public class LocalOuter {

    public void method() {
        // 지역 클래스 정의
        class LocalClass {
            void print() {
                System.out.println("LocalClass");
            }
        }

        // 지역 클래스의 인스턴스 생성
        LocalClass localClass = new LocalClass();
        localClass.print();
    }

    public static void main(String[] args) {
        LocalOuter local = new LocalOuter();
        local.method();
    }
}
```
## 지역 변수
- 지역 변수는 스택 영역의 스택 프레임 안에 존재
- 메서드가 호출 되면 생성되고, 메서드 호출이 종료되면 스택 프레임이 제거되면서 지역 변수도 모두 제거됨
## 지역 변수 캡처
- 지역 클래스의 인스턴스를 생성하는 시점에 필요한 지역 변수를 복사해서 생성한 인스턴스에 저장
- 캡처된 변수는 메소드 내에서 변경 불가(`final` 또는 `effectively final` 상태)
  - 지역 변수에 `final` 키워드를 사용하지는 않았지만, 값을 변경하지 않는 지역 변수
- 캡처한 지역 변수의 값 변경 시 동기화 문제 발생
  - 지역 변수의 값이 변경되면 스택 영역에 존재하는 지역 변수의 값과 캡처 변수의 값이 달라짐
```java
public class Capture {
    public void method() {
        final int localVar = 1; // final 변수

        // 지역 클래스 정의
        class LocalClass {
            void print() {
                System.out.println("캡처된 지역 변수: " + localVar);
            }
        }

        LocalClass localClass = new LocalClass();
        localClass.print();
    }

    public static void main(String[] args) {
        Capture capture = new Capture();
        capture.method();
    }
}
```
## 익명 클래스
- 이름이 없는 지역 클래스를 생성하는 동시에 정의, 코드가 간결해짐
- 이름이 없으므로 기본 생성자 외의 생성자 사용 불가
- 주로 인터페이스나 추상 클래스의 구현에 사용
```java
public class SimpleCalculatorExample { 
    public static void main(String[] args) {
        // 계산 작업을 수행하는 인터페이스 정의
        interface Calculator {
            int calculate(int a, int b);
        }

        // 덧셈 계산을 수행하는 익명 클래스
        Calculator addition = new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        // 곱셈 계산을 수행하는 익명 클래스
        multiplication(new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        });

        // 나눗셈 계산을 수행하는 익명 클래스(람다)
        division((Calculator) (a, b) -> a / b);
        
        int num1 = 10;
        int num2 = 20;
        
        System.out.println("덧셈 결과: " + addition.calculate(num1, num2));
        System.out.println("곱셈 결과: " + multiplication.calculate(num1, num2));
        System.out.println("나눗셈 결과: " + division.calculate(num2, num1));
    }
}
```