package study.section02.hoyunjung.quiz;

/**
 * 문제1: Thread 상속
 *
 * @author junghoyun
 * @since 9/4/24
 */
public class Quiz1 {
    public static void main(String[] args) {
        CounterThread counterThread = new CounterThread();
        counterThread.start();
    }

    static class CounterThread extends Thread {
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
