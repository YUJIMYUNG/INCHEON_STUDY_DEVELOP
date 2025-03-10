package example.상속과구현;

interface Tire2 { // 일반 타이어 인터페이스 선언
    void roll(); // 추상 메소드
}

class Car2 { // 자동차 클래스 선언
    Tire2 tire2;

    // 일반 타이어 타입으로 roll메소드 호출
    public void roll() {
        tire2.roll();
    }
}

class HankukTire2 implements Tire2 {
    // extends 는 상속 vs implements는 구현
    // interface에서의 Override는 구현이라고 한다.
    @Override
    public void roll() {
        System.out.println("한국 타이어가 회전합니다.");
    }
}

class KumhoTire2 implements Tire2 {

    @Override
    public void roll() {
        System.out.println("금호 타이어가 회전합니다.");
    }
}

public class 구현예제 {
    public static void main(String[] args) {

        // 1.
        Car2 myCar = new Car2();
        //myCar.roll(); // tire2에 인스턴스가 존재하지 않으므로 roll 메소드 실행할 때 null 이므로 NullPointException 오류

        // 2.
        Car2 yourCar = new Car2();
        yourCar.tire2 = new HankukTire2(); //추상메소드를 HankukTire2가 구현했으므로 'HankukTire2' 구현(객)체
        yourCar.roll(); // tire2에 HankukTire2인스턴스를 대입했으므로 roll이 실행된다.

        // 3.
        myCar.tire2 = new HankukTire2();
        myCar.roll();  // tire2에 HankukTire2인스턴스를 대입했으므로 roll이 실행된다.

        // 4.
        myCar.tire2 = new KumhoTire2(); //추상메소드를 KumhoTire2가 구현했으므로 'KumhoTire2' 구현(객)체
        myCar.roll();  // tire2에 KumhoTire2인스턴스를  대입했으므로 roll이 실행된다.

        // 5.
        yourCar.roll(); // tire2 변경을 안했으므로 roll 메소드가 그대로 실행 된다.
    }
}
