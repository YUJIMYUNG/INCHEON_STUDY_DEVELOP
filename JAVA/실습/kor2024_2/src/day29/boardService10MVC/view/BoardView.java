package day29.boardService10MVC.view;

import day29.boardService10MVC.controller.BoardController;
import day29.boardService10MVC.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {

    // ---------------------- 싱글톤 ---------------------------
    // 1. 지정한 클래스의 private static 객체를 생성한다.
    private static BoardView boardView = new BoardView();

    // 2. 지정한 클래스는 외부로부터 객체 생성을 차단한다.
    private BoardView(){}

    // 3. 내부의 객체를 외부로부터 직접접근이 아닌 간접접근 할 수 있도록 getter함수를 만들어준다.
    public static BoardView getInstance(){
        return boardView;
    }

    // ----------------------------------------------------------

    Scanner scan = new Scanner(System.in);

    public void mainPage(){
        while(true){
            System.out.print("1. 게시물 등록 2. 게시물 출력 선택 : ");
            int choose = scan.nextInt();

            if(choose == 1){
                boardWrite();
            } else if(choose == 2) {
                boardPrint();
            }
        }// while end
    }// main end

    // view가 해야하는 역할 : 입력과 출력만 한다.(관례적인 약속)
    // 1. 게시물 등록 함수
    void boardWrite(){
        //1.  입력
        scan.nextLine();
        System.out.print("게시물 제목");
        String content = scan.nextLine();
        System.out.print("게시물 작성");
        String writer = scan.next();
        System.out.print("게시물 비밀번호");
        int password = scan.nextInt();

        //2. 입력받은 값을 컨트롤러에게 전달
        boolean result = BoardController.getInstance().boardWrite(content, writer, password);

        //3. 컨트롤러에게 전달 후 걀과를 받아 출력하기
        if( result ) {
            System.out.println("게시물 등록 성공");
        } else {
            System.out.println("게시물 등록 실패");
        }
    } // boardWrite end

    // 2. 게시물 출력 함수
    void boardPrint(){
        // 1. 컨트롤러에게 모든 게시물(Board객체) 정보를 요청
        // 객체가 왜? 필요해? 다른 클래스에 있는 메소드를 호출하기 위해서는 객체가 필요하다.
        // 2. 컨트롤러에게 전달받은 결과를 출력
        ArrayList<BoardDto> result =  BoardController.getInstance().boardPrint(); // 게시물 출력 함수를 호출

        for(int i = 0; i< result.size(); i++){
            System.out.printf("내용 : %s, 작성자 : %s, 비밀번호 : %d \n", result.get(i).getContent(), result.get(i).getWriter(), result.get(i).getPwd());
        }
    } // boardPrint end

    /*
    게시물 1개 : Board 객체
    게시물 여러개 = ArrayList<Board>
     */
}// class end
