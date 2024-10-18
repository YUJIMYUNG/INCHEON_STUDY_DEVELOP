package exam01;

public class Ex06 {
    public static void main(String[] args) {
        int total = 0;
        for(int i = 0; i <= 100; i++){
            if(i % 2 == 1){ // i가 홀수 일때만 코드 실행
                total += i;
                System.out.println("total:" + total);
            }
        }

        for(int j = 0 ; j <=100; j++){
            if(j % 2 == 0){
                continue; // 짝수일 때 반복 건너뛰기
            }
            total += j;
            System.out.println("total:" + total);
        }

    }
}
