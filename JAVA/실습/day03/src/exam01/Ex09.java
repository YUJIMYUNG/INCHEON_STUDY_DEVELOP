package exam01;

public class Ex09 {
    public static void main(String[] args) {
        int num =10;
        //++num > 10 의 연산은 true로 ||연산자는 한 항에 true값이 있으면 결과가 true로 나옴
        //오른쪽 항을 계산하지 않음
        boolean result1 = ++num > 10 || (num = num + 20) >= 20;


        System.out.println(result1);//true
        System.out.println(num); //11
    }
}
