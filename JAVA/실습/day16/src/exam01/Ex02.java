package exam01;

public class Ex02 {
    public static void main(String[] args) {
        // Integer num1 = new Integer(100);

        Integer num2 = 200; // int 200 - 자료형이 같지 않으므로 원칙상 대입 불가능, 성능 저하
        // Integer num2 = Integer.valueof(200);  컴파일러가 자동 변환

        // Integer num3 = num1 + num2; // 객체 연산 불가능, 기본자료형만 연산 가능
        // num2.intValue() -> int (기본형) 으로 자동 변환되어 연산 함
        // Integer num3 = Integer.valueOf(..);

        //   System.out.println(num3);
    }
}
