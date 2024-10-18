package exam01;

public class Ex01 {
    public static void main(String[] args) {
        int rank = 2;

        // 'A' - case 값으로 가능, 문자형(char) : 양의 정수
        switch(rank) {
            case 1:
                System.out.println("금메달입니다.");
                break;
            case 2: //rank값이 매치되는 시점 부터 밑의 코드까지 실행됨 (break가 없을 경우)
                System.out.println("은메달입니다.");
                break; //실행 종료
            case 3:
                System.out.println("동메달입니다.");
                break; // 마지막 실행 종료는 생략 가능
            default: // 키워드가 모든 값에 매치가 안되는 경우 실행되는 코드
                System.out.println("입상");
        }
    }
}
