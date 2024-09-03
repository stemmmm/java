package study.section02.injejeong.quiz.quiz2;

import study.section02.injejeong.quiz.BioUnit;

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