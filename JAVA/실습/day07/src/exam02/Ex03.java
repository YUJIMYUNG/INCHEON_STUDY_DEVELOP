package exam02;

public class Ex03 {
    public static void main(String[] args) {
        int result1 = add(10, 20); // int add(int, int)
        System.out.println("result1="+ result1);

        int result2 = add(10, 20, 30); // int add(int, int, int)
        System.out.println("result2="+ result2);

        double result3 = add(10.0, 20); // double add(double, int)
        System.out.println("result3=" + result3);
    }


    static int add(int num1, int num2) {
        int result = num1 +num2;

        return result;
    }

    // double add(double, int)
    static double add(double num1, int num2){
        double result = num1 + num2;
        return result;
    }

    static int add(int num1, int num2, int num3) {
        int result = num1 + num2 + num3;
        return result;
    }
}
