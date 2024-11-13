package day22;

import java.util.Scanner;

// 기존 코드 : 고정 길이인 Board[] boardList = new Board[100];
// 수정 조건 : 고정길이가 아닌 가변길이 형식으로 수정하여 100개가 아닌 무한개 저장할 수 있는 가변길이 배열 만들기
public class BoardService4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 가변길이 형식으로 배열 만들기
        Board[] boardList = null;

        // 현재 게시물 수를 저장하는 변수
        int count = 0;

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

                // 2. 입력 받은 데이터로 게시물 객체 생성
                Board board = new Board();
                board.content = content;
                board.writer = writer;
                board.pwd = password;

                //3.  만약에 최초 게시물이면
                count++; // 게시물수 1 증가
                Board[] newBoardList = new Board[count]; // 새로운 배열 생성
                // 기존 배열 내 게시물들을 새로운 배열에 이동하기 / 배열 복사
                if(count != 1 ) { //만약에 기존 배열 내 게시물이 존재하면
                    for(int i = 0; i < boardList.length; i++){
                        newBoardList[i] = boardList[i]; // 기존 배열내 게시물들을 새로운 배열에 대입
                    }
                }

                // 새로운 배열 내 마지막 인덱스에 입력받은 게시물 객체 등록
                newBoardList[newBoardList.length-1] = board;

                // *** 새로운 배열을 기존 배열에 대입한다.
                boardList = newBoardList;


            } else if(choose == 2) {
                // 배열 내 존재하는 게시물 모두 출력하기
                for(int i = 0; i < boardList.length ; i++){
                    System.out.printf("내용 : %s, 작성자 : %s, 비밀번호 : %d \n", boardList[i].content, boardList[i].writer, boardList[i].pwd);
                }
            } //  if/ else if end
        } // while end
    }
}
