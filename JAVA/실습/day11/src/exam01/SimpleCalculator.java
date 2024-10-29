package exam01;

public class SimpleCalculator extends Calculator{
    public SimpleCalculator() {
        super(); //Calculator()
    }

    @Override
    public int add(int num1, int num2) { // 재정의는 인스턴스 메서드만 가능!
        return num1 + num2;
    }
}
