package exam01;

public class Ex01 {
    public static void main(String[] args) {
        //SimpleCalculator cal = new SimpleCalculator();
        Calculator cal = new SimpleCalculator(); // 권장! 유연성 good
        int result = cal.add(10, 20);
        System.out.println(result);
    }
}
