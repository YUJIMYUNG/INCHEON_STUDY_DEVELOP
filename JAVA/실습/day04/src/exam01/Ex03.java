package exam01;

public class Ex03 {
    public static void main(String[] args) {
        int num = 1;
        int total = 0;
        //num : 증가하는 수, total - 증가하는 수를 더한 값

        do {
            // 반복 수행되는 코드 블럭
            total += num;
            num++;
        } while (num <= 100); //do 코드가 멈추는 조건

        // 초기값, 조건식, 증감식 - 횟수가 있는 반복문에서 필수 요소!
        System.out.println(total);
    }
}
