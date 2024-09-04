package study.section02.hoyunjung.quiz;

/**
 * 문제2: Runnable 구현
 *
 * @author junghoyun
 * @since 9/4/24
 */
public class Quiz2 {
    public static void main(String[] args) {
        CounterRunnable counterRunnable = new CounterRunnable();
        Thread thread = new Thread(counterRunnable, "counter");
        thread.start();
    }

    static class CounterRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
