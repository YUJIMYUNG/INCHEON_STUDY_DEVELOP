package exam02;

public class Ex02 {
    public static void main(String[] args) {
        int age = 45;
        if (age < 8) {
            System.out.println("유치원생");
        } else if (age < 14) { //if 조건이 거짓일 때 실행, age >= 8 && age < 14
            System.out.println("초등학생");
        } else if ( age < 17) { // if 조건과 else if 첫번째 조건이 모두 false일 때 실행, age >= 14 && age < 17
            System.out.println("중학생");
        } else if ( age < 20) { // if 조건과 else if 첫번째, 두번째 조건이 모두 false일 때 실행, age >= 17 && age < 20
            System.out.println("고등학생");
        } else { // 위 조건들이 모두 false일때 실행
            System.out.println("성인");
        }
    }
}
