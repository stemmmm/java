package study.week4.section06.hoyunjung.question;

import java.time.LocalDateTime;

/**
 * 문제1 - 날짜 더하기
 *
 * @author junghoyun
 * @since 8/16/24
 */
public class Question1 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2024, 1, 1, 0, 0, 0)
            .plusYears(1)
            .plusMonths(2)
            .plusDays(3)
            .plusHours(4);

        System.out.println(localDateTime);
    }
}
