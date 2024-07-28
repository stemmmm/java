# 객체 지향 프로그래밍
## 절차 지향 프로그래밍
- 실행 순서를 중심으로 프로그램 설계
## 객체 지향 프로그래밍
- 클래스에서 생겨난 실체인 객체들의 상호작용을 중심으로 프로그램 설계
- 객체 지향 프로그램이 절차를 중요시하지 않는 것은 아님
## 객체 지향 프로그래밍 vs 절차 지향 프로그래밍
- 데이터의 처리 방식의 차이
- 절차 지향 프로그래밍은 데이터와 함수가 분리되어 있음
- 객체 지향 프로그래밍은 모듈화를 통해 효율적으로 데이터 관리
## 문제와 풀이
- 절차 지향 직사각형 프로그램을 객체 지향으로 변경하기
```java
// 직사각형의 넓이(Area), 둘레 길이(Perimeter), 정사각형 여부(square)를 구하는 프로그램
public class Rectangle {
    int width;
    int height;

    int calculateArea() {
        return width * height;
    }
    int calculatePerimeter() {
        return 2 * (width + height);
    }
    boolean isSquare() {
        return width == height;
    }
}
```
```java
public class RectangleOopMain {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.width = 5;
        rectangle.height = 8;

        int area = rectangle.calculateArea();
        System.out.println("넓이: " + area);

        int perimeter = rectangle.calculatePerimeter();
        System.out.println("둘레 길이: " + perimeter);

        boolean square = rectangle.isSquare();
        System.out.println("정사각형 여부: " + square);
    }
}
```
```java
// 은행 계좌
public class Account {
    int balance;

    void deposit(int amount) {
        balance += amount;
    }

    void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("잔액이 부족합니다.");
        }
    }
}
```
```java
public class AccountMain {
    public static void main(String[] args) {
        Account account = new Account();

        account.deposit(10000);
        account.withdraw(9000);
        account.withdraw(2000);

        System.out.println("잔고: " + account.balance);
    }
}
```