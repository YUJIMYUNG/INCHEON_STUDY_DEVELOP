package exam01;

public class Ex02 {
    public static void main(String[] args) {
        int num = 1; // 증가사는 수 (초기식)
        int total = 0; //더해지는 합

        while( num <= 100) { // num 이 100이하일때까지 반복
            total += num;
            num++;
        }

        System.out.println(total);


    }
}
