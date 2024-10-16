package exam02;

public class Ex04 {
    public static void main(String[] args) {
        int num1 = 100000; // 4byte
        byte num2 = (byte)num1; // 명시적 형변환 - 강제 형변환 (데이터 유실 발생 가능)
        System.out.println(num2); //-96출력됨 - 데이터 변질

    }
}
