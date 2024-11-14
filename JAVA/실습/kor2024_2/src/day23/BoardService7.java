package day23;

/*
// BoardService7
// 추가조건 :
// 클래스에서 main함수내 while{} 문 안에 있는 게시물 등록코드 와 게시물 전체 출력코드를 main함수 밖으로 빼서 각 함수로 구현 하시오.
// 분리를 하는 이유 : 메소드는 기능 단위로 분리해서 하나의 함수로 묶으면/관리/사용, 추후에 복잡한 프로젝트에서 유지보수/식별/ 구분이 쉽다.
//  - static이란 ? static키워드가 존재하는 변수 혹은 메소드(함수)는 우선 할당(프로그램 실행시 메모리에 적재)이 된다.
//      - static main 함수 내에서 다른 함수가 실행되지 않는 이유(다양한 이유)
//          1. static main 함수 안에서는 호출 할 함수가 static 이어야 한다.
                - main 함수가 먼저 실행되므로 호출 할 함수의 정보를 모른다.
            2. static main 함수 안에서는 다른 클래스의 메소드를 호출하기 위해서는 객체가 필요하다.
                - 객체를 생성하면서 static이 아닌 메소드 정보를 읽어들인다.

 */
import java.util.ArrayList;
import java.util.Scanner;

public class BoardService7 {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Board> boardList= new ArrayList<>();

    public static void main(String[] args) {
        while(true) {
            System.out.print("1.글쓰기 2. 출력");
            int choose = scan.nextInt();

            if(choose == 1){
                boardWrite();
            } else if(choose == 2) {
                boardPrint();
            } //  if/ else if end
        } // while end
    } //  main end

    static void boardWrite(){
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

        Board board = new Board(content, writer, password);
        // 3. 컬렉션 프레임워크인 리스트객체에 게시물을 저장한다.
        boardList.add(board);
    }

    static void boardPrint(){
        // 배열 내 존재하는 게시물 모두 출력하기
        for(int i = 0; i < boardList.size() ; i++){
            System.out.printf("내용 : %s, 작성자 : %s, 비밀번호 : %d \n", boardList.get(i).getContent(), boardList.get(i).getWriter(), boardList.get(i).getPwd());
        }
    }

}
