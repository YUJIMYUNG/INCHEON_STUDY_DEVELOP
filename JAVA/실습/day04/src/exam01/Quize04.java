package exam01;

public class Quize04 {
    public static void main(String[] args) {
        //구구단을 홀수 단만 출력하도록 프로그램을 만드시오.
        for(int i = 3; i < 10; i++){
            for(int j = 2; j < 10; j++){
                if(i % 2 == 1){
                    System.out.printf("%d X %d = %d%n", i, j, i*j);
                }
            }
        }
    }
}
