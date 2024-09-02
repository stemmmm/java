package study.section06.injejeong.quiz;

import java.time.LocalDateTime;

public class Quiz1 {
    public static void main(String[] args) {
        // 2024년 1월 1일 0시 0분 0초에서 1년 2개월 3일 4시간 후의 시각
        LocalDateTime localDateTime = LocalDateTime.of(2024, 1, 1, 0, 0, 0);
        LocalDateTime futureDateTime = localDateTime.plusYears(1).plusMonths(2).plusDays(3).plusHours(4);
        System.out.println("기준 시각: " + localDateTime);
        System.out.println("1년 2개월 3일 4시간 후의 시각: " + futureDateTime);
    }
}
