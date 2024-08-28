package study.week5.section02.hoyunjung.question.question2;

import study.week5.section02.hoyunjung.question.BioUnit;

public class Shuttle<T extends BioUnit> {
    private T unit;

    public void in(T t) {
        unit = t;
    }

    public T out() {
        return unit;
    }

    public void showInfo() {
        System.out.println("이름: " + unit.getName() + ", HP: " + unit.getHp());
    }
}
