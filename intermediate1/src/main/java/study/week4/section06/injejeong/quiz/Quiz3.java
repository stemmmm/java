package study.week4.section06.injejeong.quiz;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Quiz3 {
    public static void main(String[] args) {
        // 시작 날짜와 목표 날짜 입력, 남은 기간과 디데이 출력
        LocalDate startDate = LocalDate.of(2024, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 11, 21);
        System.out.println("시작 날짜: " + startDate);
        System.out.println("목표 날짜: " + endDate);

        Period period = Period.between(startDate, endDate);
        System.out.println("남은 기간: " + period.getYears() + "년 " + period.getMonths() + "개월 " + period.getDays() + "일");

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("D-" + daysBetween);
    }
}
