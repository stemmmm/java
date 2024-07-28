# 1. 클래스와 데이터

## 클래스
- 객체를 정의하고 생성하는 데에 사용하는 설계도
- 객체의 속성과 기능을 포함하며 각각 변수와 메소드로 표현
```java
public class Example {} // 클래스 선언
```
## 객체
- 클래스에서 정의된 속성과 기능을 가진 실체
- 프로그램에서 작업을 실제로 수행함
- '.'을 이용하여 객체에 접근 가능
```java
Example ex = new Example(); // 객체 생성
```
## 클래스가 필요한 이유
- 유사한 기능의 코드를 재사용할 수 있음
- 관련성이 있는 코드를 구조화하여 유지보수 용이

## 문제와 풀이
- 영화 리뷰 관리하기 1
```java
// MovieReview 클래스, title과 review를 멤버변수로 가진다
public class MovieReview { 
    String title;
    String review;
}
```
```java
// MovieReview 클래스를 활용하여 객체를 생성하고, main 메서드를 통해 객체 생성 및 출력 
public class MovieReviewMain {
    public static void main(String[] args) {
        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한 루프";

        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃 타임";
        aboutTime.review = "인생 시간 영화";

        System.out.println("영화 제목: " + inception.title + ", 리뷰: " + inception.review);
        System.out.println("영화 제목: " + aboutTime.title + ", 리뷰: " + aboutTime.review);
    }
}
```
- 영화 리뷰 관리하기 2
```java
// MovieReviewMain에 배열 도입, for문으로 배열 출력
public class MovieReviewMain2 {
    public static void main(String[] args) {
        MovieReview[] reviews = new MovieReview[2];

        MovieReview inception = new MovieReview();
        inception.title = "인셉션";
        inception.review = "인생은 무한 루프";
        reviews[0] = inception;

        MovieReview aboutTime = new MovieReview();
        aboutTime.title = "어바웃 타임";
        aboutTime.review = "인생 시간 영화";
        reviews[1] = aboutTime;

        for (MovieReview review : reviews) {
            System.out.println("영화 제목: " + review.title + ", 리뷰: " + review.review);
        }
    }
}
```
- 상품 주문 시스템
```java
// productName, price, quantity를 멤버변수로 가진다.
public class ProductOrder {
    String productName;
    int price;
    int quantity;
}
```
```java
// 상품들의 주문 정보를 배열에 저장, 상품 정보 및 최종 결제 금액 출력
public class ProductOrderMain {
    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];

        ProductOrder order1 = new ProductOrder();
        order1.productName = "두부";
        order1.price = 2000;
        order1.quantity = 2;
        orders[0] = order1;

        ProductOrder order2 = new ProductOrder();
        order2.productName = "김치";
        order2.price = 5000;
        order2.quantity = 1;
        orders[1] = order2;

        ProductOrder order3 = new ProductOrder();
        order3.productName = "콜라";
        order3.price = 1500;
        order3.quantity = 2;
        orders[2] = order3;

        int totalAmount = 0;

        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
            totalAmount += order.price * order.quantity;
        }

        System.out.println("총 결제 금액: " + totalAmount);
    }
}
```