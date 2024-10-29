package exam01;

public class Ex01 {
    public static void main(String[] args) {
        //Calculator calculator = new Calculator();
        SimpleCalculator calculator = new SimpleCalculator();
        int result = calculator.add(10, 20);
        System.out.println(result);
        System.out.println(calculator.num1); // Calculator 추상 클래스이지만 객체가 되었다!
    }
}
