package study.section06.hoyunjung.quiz;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * 문제4: 시작 요일, 마지막 요일 구하기
 *
 * @author junghoyun
 * @since 8/16/24
 */
public class Quiz4 {
    public static void main(String[] args) {
        int year = 2024;
        int month = 1;

        LocalDate localDate = LocalDate.of(year, month, 1);
        System.out.println("시작 요일: " + localDate.getDayOfWeek());
        System.out.println("마지막 요일: " + localDate.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek());
    }
}
