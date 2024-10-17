package exam01;

public class Ex07{
    public static void main(String[] args) {
        int num = 50;
        boolean result1 = num >= 10; //num이 10 이상이냐?의 결과를 result에 담아라
        boolean result2 = num <=100;
        System.out.println(result1); //true

        //num이 10이상이고 100이하인지 판별하고 싶을 때
        boolean result3 = result1 && result2; //result1, result2 모두 참일때 result3은 참이다
        System.out.println(result3); //true


    }
}
