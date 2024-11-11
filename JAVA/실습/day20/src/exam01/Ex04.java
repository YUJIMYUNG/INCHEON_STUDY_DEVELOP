package exam01;

public class Ex04 {
    public static void main(String[] args) {
        int c = 10;

        Calculator cal2 = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                //c = 20; // 지역변수의 상수화 final int c; 외부에 정의된 지역변수는 인터페이스 내에서 사용할 수 없다!
                return num1 + num2;
            }
        };

        Calculator cal = (a, b) -> {
            // c = 20; 지역변수의 상수화 final int c;
            return a + b;
        };
    }
}
