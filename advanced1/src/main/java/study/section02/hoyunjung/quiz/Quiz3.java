package study.section02.hoyunjung.quiz;

/**
 * 문제3: 람다 사용
 *
 * @author junghoyun
 * @since 9/4/24
 */
public class Quiz3 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "counter");

        thread.start();
    }
}

