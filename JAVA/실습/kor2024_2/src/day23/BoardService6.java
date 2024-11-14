package day23;

// BoardService6
// BoardService5 모든 코드를 복사후 진행
// 추가 조건 : NewBoard 클래스 객체들을 캡슐화(접근제한자) 하시오
//          1. NewBoard는 Board와 동일한 내용으로 구성
//          2. NewBoard의 모든 필드(멤버변수) 는 private 으로 선언한다.
//          3. 외부에서 객체 생성시 생성자를 사용한다.
//          4. getter(필드값호출함수), setter(필드값 대입함수), toString(객체정보함수) 함수들을 이용하여 모든 필드의 데이터를 간접 접근한다.

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 컬렉션 프레임워크 중 ArrayList클래스를 이용한 배열을 대체한다.
        //  개발자에게 편의성 제공
        //      ArrayList<제네릭타입> : 리스트 객체에 저장할 여러개 객체들의 타입
        // 배열(고정길이) vs 컬렉션 프레임워크(가변길이)
        ArrayList<Board> boardList= new ArrayList<>();

        // 의존성 주입
        Board board = new Board();

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

                // 2. 입력 받은 데이터를 arrayList에 저장
               board.setContent(content);
               board.setWriter(writer);
               board.setPwd(password);

                // 3. 컬렉션 프레임워크인 리스트객체에 게시물을 저장한다.
                boardList.add(board);

            } else if(choose == 2) {
                // 배열 내 존재하는 게시물 모두 출력하기
                for(int i = 0; i < boardList.size() ; i++){
                    System.out.printf("내용 : %s, 작성자 : %s, 비밀번호 : %d \n", boardList.get(i).getContent(), boardList.get(i).getWriter(), boardList.get(i).getPwd());
                }
            } //  if/ else if end
        } // while end
    }
}
