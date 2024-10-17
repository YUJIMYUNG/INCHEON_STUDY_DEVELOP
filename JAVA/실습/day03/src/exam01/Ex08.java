package exam01;

public class Ex08 {
    public static void main(String[] args) {
        int num = 10;
        //num++ 뒤에 >연산자가 있으니 num++1은 11
        boolean result1 = num++ > 10 && (num = num + 20) > 20;

        System.out.println(num); // 11 출력
                                // 왼쪽 항이 false : 판별 완료(&&은 하나만 false 있으면 결과도 false가 되기 때문에)
                                //되어 오른쪽 항을 체크하지 않음


    }
}
