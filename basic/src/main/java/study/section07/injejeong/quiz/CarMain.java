package study.section07.injejeong.quiz;

import study.section07.injejeong.quiz.Car;

public class CarMain {
    public static void main(String[] args) {
        // 생성한 차량 수를 출력하는 프로그램
        Car car1 = new Car("K3");
        Car car2 = new Car("G80");
        Car car3 = new Car("Model Y");

        Car.showTotalCars();
    }
}
