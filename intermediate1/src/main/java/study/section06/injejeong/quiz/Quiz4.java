package study.section06.injejeong.quiz;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Quiz4 {
    public static void main(String[] args) {
        // 입력 받은 월의 첫 날 요일과 마지막 날 요일 출력
        int year = 2024;
        int month = 1;

        LocalDate date = LocalDate.of(year, month, 1);

        System.out.println("첫 날 요일: " + date.getDayOfWeek());
        System.out.println("마지막 날 요일 = " + date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek());
    }
}
