package study.week4.section06.hoyunjung.question;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 문제5 - 국제 회의 시간
 *
 * @author junghoyun
 * @since 8/16/24
 */
public class Question5 {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2024, 1, 1);
        LocalTime localTime = LocalTime.of(9, 0);
        ZoneId zoneId = ZoneId.of("Asia/Seoul");

        ZonedDateTime seoulDateTime = ZonedDateTime.of(localDate, localTime, zoneId);
        ZonedDateTime londonDateTime = seoulDateTime.withZoneSameInstant(ZoneId.of("Europe/London"));
        ZonedDateTime newYorkDateTime = seoulDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println("서울: " + seoulDateTime);
        System.out.println("런던: " + londonDateTime);
        System.out.println("뉴욕: " + newYorkDateTime);
    }
}
