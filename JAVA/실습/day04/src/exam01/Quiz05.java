package exam01;

public class Quiz05 {
    public static void main(String[] args) {
        //구구단을 단보다 곱하는 수가 크거나 같은 경우만 출력하는 프로그램을 만들어 보세요
        for(int i = 2; i < 10; i++){
            for(int j = 1; j < 10; j++){
                if(i <= j){
                    System.out.printf("%d X %d = %d%n", i, j, i*j);
                }
            }
        }
    }
}
