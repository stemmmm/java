package study.section06.hoyunjung.quiz;

import java.time.LocalDate;

/**
 * 문제2 - 날짜 간격 반복 출력하기
 *
 * @author junghoyun
 * @since 8/16/24
 */
public class Quiz2 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2024, 1, 1);

        for (int i = 0; i < 5; i++) {
            System.out.println(localDate);
            localDate = localDate.plusWeeks(2);
        }
    }
}
