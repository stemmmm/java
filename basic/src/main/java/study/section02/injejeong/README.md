# 기본형과 참조형
## 기본형(primitive type)
- byte, short, int, long, char, float, double, boolean의 8개, 모두 소문자로 시작
- 메모리에 실제 값을 저장하며, 변수에 사용할 값을 직접 대입할 수 있다
- 자바에서 제공, 개발자가 추가할 수 없음
## 참조형(reference type)
- 기본형을 제외한 모든 자료형, 대문자로 시작
- 메모리에 데이터에 접근할 수 있는 주소값을 저장
- 'new' 키워드로 값 초기화(생성)
## 메서드 호출
- 대원칙 - 자바는 항상 변수의 값을 복사해서 대입한다.
- 기본형: 실제 값을 복사하여 전달하므로 메서드 내부에서 매개변수의 값을 변경해도, 실제 값은 불변
- 참조형: 참조값을 복사하여 전달하므로 메서드 내부에서 객체의 멤버변수 변경 시 호출자의 객제도 변경됨
## null
- 참조형 변수에서 가리키는 값이 없는 상태, 값이 존재하지 않는다는 뜻
- NullPointerException: null 상태인 객체에 '.'을 통해 접근 시 발생하는 예외
## 문제와 풀이
- 상품 주문 시스템 리팩토링
```java
public class ProductOrder {
    String productName;
    int price;
    int quantity;
}
```
```java
// 주문을 생성, 출력하고, 총 결제 금액을 계산하여 반환하는 메서드 추가
public class ProductOrderMain2 {
    public static void main(String[] args) {
        ProductOrder[] orders = new ProductOrder[3];
        orders[0] = createOrder("두부", 2000, 2);
        orders[1] = createOrder("김치", 5000, 1);
        orders[2] = createOrder("콜라", 1500, 2);

        printOrders(orders);
        int totalAmount = getTotalAmount(orders);
        System.out.println("총 결제 금액: " + totalAmount);
    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;
        for (ProductOrder order : orders) {
            totalAmount += order.price * order.quantity;
        }
        return totalAmount;
    }
}
```
- 상품 주문 시스템 - 사용자 입력
```java
// 상품 주문 개수, 가격, 상품 수량, 상품명을 입력받고 등록한 상품과 총 결제 금액 출력
public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        ProductOrder[] orders = new ProductOrder[n];
        for (int i = 0; i < orders.length; i++) {
            System.out.println((i+1) + "번째 주문 정보를 입력하세요");

            System.out.print("상품명: ");
            String productName = scanner.nextLine();

            System.out.print("가격: ");
            int price = scanner.nextInt();

            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            orders[i] =  createOrder(productName, price, quantity);
        }

        printOrders(orders);

        int totalAmount = getTotalAmount(orders);
        System.out.println("총 결제 금액: " + totalAmount);
    }

    static ProductOrder createOrder(String productName, int price, int quantity) {
        ProductOrder order = new ProductOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    static void printOrders(ProductOrder[] orders) {
        for (ProductOrder order : orders) {
            System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
        }
    }

    static int getTotalAmount(ProductOrder[] orders) {
        int totalAmount = 0;
        for (ProductOrder order : orders) {
            totalAmount += order.price * order.quantity;
        }
        return totalAmount;
    }
}
```