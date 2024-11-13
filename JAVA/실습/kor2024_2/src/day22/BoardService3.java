package day22;

// BoardService3
// - 내용[String타입] 과 작성자[String타입] 과 비밀번호[int타입] 로 구성된 게시물 클래스를 설계
//      - 게시물 객체 최대 100개 까지 저장하는 서비스 구축
//          - 조건 : main함수 1개 와 배열은 최대1까지 사용 하여 구현
//          - 구축 : 게시물 쓰기 와 게시물 출력 기능 구현\
// - 타입 : 데이터 형태를 분류
//      - 기본타입  boolean, byte, short, int, long, double, float, char
//      - 참조타입 : 배열, 클래스, 인터페이스, 열거타입 등등
// - 클래스 : 객체지향 프로그래밍 매우 중요한 문법
//           타입 만들기
//           멤버변수(필드), 생성자, 메소드(멤버함수) 로 구성된 새로운 타입 만들기
// - 객체 : 물리적/논리적으로 정의(툭성, 행위)가 가능한 형태물, 의자, 안경, 책, 강의(논리)
//         하나의 자료(여러개 자료들의 주소값)를 저장하는 메모리 공간 (JVM 힙 영역)
//         참조 타입으로 생성된 메모리 공간
// - 변수 : 하나의 자료(실제값, 주소값)를 저장하는 메모리 공간(JVM stack영역)
//         기본/참조 타입으로 생성된 메모리 공간

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class BoardService3 { // 실행 클래스
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Board 객체 100개를 저장할 수 있는 배열 생성
        Board[] boardList = new Board[100]; // 고정길이

        while(true) {
            System.out.print("1.글쓰기 2. 출력");
            int choose = scan.nextInt();

            if(choose == 1){
                scan.nextLine();
                // 사용자로부터 저장할 데이터 입력을 받는다.
                System.out.print("게시물 제목");
                String content = scan.nextLine();
                // .next() 문자열(공백x) 입력, .nextLine() 문자열(공백/띄어쓰기 포함)입력
                // .nextLine() 사용시 주의할점 : .nextLine()앞에 또 다른 .nextxx가 존재하면 의미없는 .nextLine()코드를 작성하낟.
                System.out.print("게시물 작성");
                String writer = scan.next();

                System.out.print("게시물 비밀번호");
                int password = scan.nextInt();

                // 배열 내 빈 공간을 찾아서 게시물 작성하기
                for(int i = 0; i < boardList.length ; i++){
                    if(boardList[i] == null){ // 만약에 i번째 게시물이 비어잇으면
                        // 게시물 객체 생성
                        Board board = new Board();

                        // 생성된 객체 내 입력받은 값들을 대입한다.
                        board.content = content;
                        board.writer = writer;
                        board.pwd = password;

                        // 배열 내 i번째 위치에 생성한 객체를 대입한다.
                        boardList[i] = board;

                        break;
                    } // if end
                } // for end

            } else if(choose == 2) {
                // 배열 내 존재하는 게시물 모두 출력하기
                for(int i = 0; i < boardList.length ; i++){
                    if(boardList[i] != null){
                        System.out.printf("내용 : %s, 작성자 : %s, 비밀번호 : %d \n", boardList[i].content, boardList[i].writer, boardList[i].pwd);
                    }
                }
            } //  if/ else if end
        } // while end
    }
}
