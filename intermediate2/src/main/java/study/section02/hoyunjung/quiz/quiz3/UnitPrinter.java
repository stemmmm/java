package study.section02.hoyunjung.quiz.quiz3;

import study.section02.hoyunjung.quiz.BioUnit;
import study.section02.hoyunjung.quiz.quiz2.Shuttle;

public class UnitPrinter {
    public static <T extends BioUnit> void printV1(Shuttle<T> shuttle) {
        shuttle.showInfo();
    }

    public static void printV2(Shuttle<? extends BioUnit> shuttle) {
        shuttle.showInfo();
    }
}
