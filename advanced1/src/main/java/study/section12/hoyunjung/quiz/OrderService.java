package study.section12.hoyunjung.quiz;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class OrderService {
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public void order(String orderNo) throws InterruptedException, ExecutionException {
        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);

        try {
            Future<Boolean> inventoryFuture = executorService.submit(inventoryWork);
            Future<Boolean> shippingFuture = executorService.submit(shippingWork);
            Future<Boolean> accountingFuture = executorService.submit(accountingWork);

            // 작업 완료 기다림(get은 블로킹 메서드이므로 한 번에 submit 후 한 번에 get 해야함에 주의)
            Boolean inventoryResult = inventoryFuture.get();
            Boolean shippingResult = shippingFuture.get();
            Boolean accountingResult = accountingFuture.get();

            // 결과 확인
            if (inventoryResult && shippingResult && accountingResult) {
                System.out.println("모든 주문 처리가 성공적으로 완료되었습니다.");
            } else {
                System.out.println("일부 작업이 실패했습니다.");
            }
        } finally {
            executorService.close();
        }
    }

    static class InventoryWork implements Callable<Boolean> {
        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() throws InterruptedException {
            System.out.println("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class ShippingWork implements Callable<Boolean> {
        private final String orderNo;

        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() throws InterruptedException {
            System.out.println("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }

    static class AccountingWork implements Callable<Boolean> {
        private final String orderNo;

        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }

        public Boolean call() throws InterruptedException {
            System.out.println("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}