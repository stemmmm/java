package study.section02.hoyunjung.quiz;

/**
 * 문제4: 여러 스레드 사용
 *
 * @author junghoyun
 * @since 9/4/24
 */
public class Quiz4 {
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1_000);
                    System.out.println("A");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "threadA");

        Thread threadB = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(500);
                    System.out.println("B");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "threadB");

        threadA.start();
        threadB.start();
    }
}
