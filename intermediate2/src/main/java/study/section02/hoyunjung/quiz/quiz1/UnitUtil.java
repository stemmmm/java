package study.section02.hoyunjung.quiz.quiz1;

import study.section02.hoyunjung.quiz.BioUnit;

public class UnitUtil {
    static <T extends BioUnit> T maxHp(T unitA, T unitB) {
        return unitA.getHp() > unitB.getHp() ? unitA : unitB;
    }
}
