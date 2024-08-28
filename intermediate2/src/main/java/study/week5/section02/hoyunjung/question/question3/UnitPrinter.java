package study.week5.section02.hoyunjung.question.question3;

import study.week5.section02.hoyunjung.question.BioUnit;
import study.week5.section02.hoyunjung.question.question2.Shuttle;

public class UnitPrinter {
    public static <T extends BioUnit> void printV1(Shuttle<T> shuttle) {
        shuttle.showInfo();
    }

    public static void printV2(Shuttle<? extends BioUnit> shuttle) {
        shuttle.showInfo();
    }
}
