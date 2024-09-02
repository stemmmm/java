package study.section06.injejeong.quiz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Quiz2 {
    public static void main(String[] args) {
        // 2024년 1월 1일 부터 2주 간격으로 5번 반복하여 날짜를 출력
        LocalDate localDate = LocalDate.of(2024, 1, 1);
        System.out.println(localDate);

        for (int i = 0; i < 5; i++) {
            localDate = localDate.plusWeeks(2);
            System.out.println(localDate);
        }
    }
}
