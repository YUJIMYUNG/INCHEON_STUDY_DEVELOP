package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Calculator cal = new Calculator() {
            @Override
            public int add(int num1, int num2) {
                return num1 + num2;
            }
        };

        // cal 과 똑같은 형식
//        Calculator cal2 = (int num1, int num2) -> {
//            return num1 + num2;
//        };
        // ==
//        Calculator cal2 = (int num1, int num2) -> num1 + num2;
        // ==
        Calculator cal2 = (a, b) -> a + b;
        int result = cal2.add(10,20);
        System.out.println(result);
    }
}
