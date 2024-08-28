package study.week5.section02.hoyunjung.question.question1;

import study.week5.section02.hoyunjung.question.BioUnit;

public class UnitUtil {
    static <T extends BioUnit> T maxHp(T unitA, T unitB) {
        return unitA.getHp() > unitB.getHp() ? unitA : unitB;
    }
}
