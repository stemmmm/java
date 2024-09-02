package study.week4.section06.injejeong.quiz;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Quiz5 {
    public static void main(String[] args) {
        // 서울의 회의 시간이 2024년 1월 1일 오전 9시일 때  런던, 뉴욕의 회의 시간 출력
        ZonedDateTime seoulTime = ZonedDateTime.of(LocalDate.of(2024, 1, 1),LocalTime.of(9, 0), ZoneId.of("Asia/Seoul"));
        ZonedDateTime londonTime = seoulTime.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime newYorkTime = seoulTime.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println("서울의 회의 시간: " + seoulTime);
        System.out.println("런던의 회의 시간: " + londonTime);
        System.out.println("뉴욕의 회의 시간: " + newYorkTime);
    }
}
