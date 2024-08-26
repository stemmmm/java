package study.week4.section06.hoyunjung.question;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 문제3 - 디데이 구하기
 *
 * @author junghoyun
 * @since 8/16/24
 */
public class Question3 {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 8, 7);
        LocalDate endDate = LocalDate.of(2025, 2, 7);
        System.out.println("시작 날짜: " + startDate);
        System.out.println("목표 날짜: " + endDate);

        Period between = Period.between(startDate, endDate);
        System.out.println("남은 기간: " + between.getYears() + "년 " + between.getMonths() + "개월 "  + between.getDays() + "일");

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("D-DAY: " + daysBetween + "일");
    }
}
