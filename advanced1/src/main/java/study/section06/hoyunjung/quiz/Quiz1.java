package study.section06.hoyunjung.quiz;

import lombok.Getter;

/**
 * 문제1: 공유 자원
 *
 * @author junghoyun
 * @since 9/10/24
 */
public class Quiz1 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    counter.increment();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("결과: " + counter.getCount());
    }

    @Getter
    static class Counter {
        private int count = 0;

        public synchronized void increment() {
            count = count + 1;
        }
    }
}
