package study.section07.injejeong.quiz;

import study.week2.section07.injejeong.quiz.Car;

public class CarMain {
    public static void main(String[] args) {
        // 생성한 차량 수를 출력하는 프로그램
        study.week2.section07.injejeong.quiz.Car car1 = new study.week2.section07.injejeong.quiz.Car("K3");
        study.week2.section07.injejeong.quiz.Car car2 = new study.week2.section07.injejeong.quiz.Car("G80");
        study.week2.section07.injejeong.quiz.Car car3 = new study.week2.section07.injejeong.quiz.Car("Model Y");

        Car.showTotalCars();
    }
}
