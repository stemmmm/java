package study.section12.hoyunjung.quiz;

import java.util.concurrent.ExecutionException;

public class OrderServiceTestMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        String orderNo = "Order#1234";
        OrderService orderService = new OrderService();
        orderService.order(orderNo);
    }
}