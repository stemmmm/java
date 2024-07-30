package study.week2.section09.hoyunjung;

import study.week2.section09.hoyunjung.car.ElectricCar;

public class Main {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();

        // ElectricCar의 move 호출을 시도했지만, ElectircCar에는 오버라이딩된 move 메서드가 없으므로 부모 클래스 Car의 move가 실행됨
        electricCar.move();
    }
}
