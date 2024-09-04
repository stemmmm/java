package study.section02.injejeong.quiz.quiz3;

import study.section02.injejeong.quiz.BioUnit;
import study.section02.injejeong.quiz.quiz2.Shuttle;

public class UnitPrinter {
    public static <T extends BioUnit> void printV1(Shuttle<T> t1) {
        t1.showInfo();
    }

    public static void printV2(Shuttle<? extends BioUnit> t1) {
        t1.showInfo();
    }
}
