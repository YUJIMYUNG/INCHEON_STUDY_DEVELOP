package example.상속과구현;

class Car {
    Tire tire; // 타이어 타입으로 멤버변수 생성

    public void run() {
        this.tire.roll(); // 타이어 타입의 roll메소드를 호출/사용
    }
}

class Tire {
    public void roll() {
        System.out.println("일반 타이어가 회전합니다.");
    }
}

class KumhoTire extends Tire{
    // extends 키워드 Tire 타입에게 물려받은 메소드를 재정의 : 오버라이딩
    @Override
    public void roll() {
        System.out.println("금호 타이어가 회전합니다.");
    }
}

class HankookTire extends Tire{
    @Override
    public void roll() {
        System.out.println("한국 타이어가 회전합니다.");
    }
}

public class 상속예제 {
    public static void main(String[] args) {

        // 1. Car 객체는 존재하지만 Car 객체 내 tire 객체가 존재하지 않으므로 오류 발생
        // myCar.run() --> tire.roll() 을 할 수 없음
        Car myCar = new Car();
        myCar.run(); // NullpointerException

        // 2. yourCar 객체 내 Tire 객체를 대입했으므로 Car객체는 존재하고 Car객체 내 tire객체가 존재하므로 오류가 없다.
        Car yourCar = new Car();
        yourCar.tire = new Tire();
        yourCar.run();;

        // 3. myCar 객체 내 Tire객체를 대입했으므로 Car객체는 존재하고 Car 객체내 tire 객체가 존재하므로 오류가 없다.
        myCar.tire = new Tire();
        myCar.run();

        // 4 .  Car객체는 존재하고 Car 객체내 Kumhotire 객체가 존재하므로 오류가 없다.
        myCar.tire = new KumhoTire();
        myCar.run();

        // 5.Car객체는 존재하고 Car 객체내 HankookTire 객체가 존재하므로 오류가 없다.
        myCar.tire = new HankookTire();
        myCar.run();

        // 6. yourCar 객체는 tire 변경(대입)하지 않으므로 그대로 Tire객체가 존재한다.
        yourCar.run();

        // 즉
        // 1. 메소드 호출하기 위해서는 인스턴스(New)가 필요하다.
        // 2. Tire 타입에는 KumhoTire 와 HankookTire 가 대입된다. 다형성 특징

    }
}
