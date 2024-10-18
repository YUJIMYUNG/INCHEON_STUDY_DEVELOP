package exam01;

public class Ex05 {
    public static void main(String[] args) {
        int total = 0;
        for (int i = 0,  j = 100; i <= 100; i++, j--){
            total += i;
            System.out.println(" j = " + j);

            if(i == 50){
                break;// 반복 중단
            }
        }

        System.out.println(total);

    }
}
