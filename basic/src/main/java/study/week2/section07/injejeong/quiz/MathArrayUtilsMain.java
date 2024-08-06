package study.week2.section07.injejeong.quiz;

import static study.week2.section07.injejeong.quiz.MathArrayUtils.*;

public class MathArrayUtilsMain {
    public static void main(String[] args) {
        // 배열용 수학 유틸리티 클래스
        int[] values = {1, 2, 3, 4, 5};
        System.out.println("sum=" + sum(values));
        System.out.println("average=" + average(values));
        System.out.println("min=" + min(values));
        System.out.println("max=" + max(values));
    }
}
