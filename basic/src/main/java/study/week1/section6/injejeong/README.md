# 접근 제어자
- 외부에서 클래스 내에 선언된 변수나 메서드로의 접근을 허용 혹은 제한할 수 있음
- 속성과 기능을 외부로부터 숨기는 것(캡슐화)이 핵심
## 접근 제어자의 종류
- private : 모든 외부 호출을 막는다.
- default (package-private): 같은 패키지안에서 호출은 허용한다. 접근 제어자를 명시하지 않을 시 적용됨
- protected : 같은 패키지안에서 호출은 허용한다. 패키지가 달라도 상속 관계의 호출은 허용한다.
- public : 모든 외부 호출을 허용한다.
## 접근 제어자 사용 - 클래스 레벨
- private, protected 사용 불가
- public 클래스 이름은 파일명과 동일해야함
- 자바 파일 내에서 public 클래스는 하나만 존재해야 함
## 문제와 풀이
- 최대 카운터와 캡슐화
```java
// 최대값을 지정하고 최대값 까지만 값이 증가하는 기능을 제공
public class MaxCounter {
    private int count = 0;
    private int max;

    public MaxCounter(int max) {
        this.max = max;
    }

    public void increment() {
        if (count >= max) {
            System.out.println("최대값을 초과할 수 없습니다.");
            return;
        }
        count++;
    }

    public int getCount() {
        return count;
    }
}
```
```java
public class CounterMain {
    public static void main(String[] args) {
        MaxCounter counter = new MaxCounter(3);
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        int count = counter.getCount();
        System.out.println(count);
    }
}
```