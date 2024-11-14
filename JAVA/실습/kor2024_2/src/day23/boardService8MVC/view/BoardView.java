package day23.boardService8MVC.view;

import day23.boardService8MVC.controller.BoardController;

import java.util.Scanner;

public class BoardView {

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
        BoardController boardController = new BoardController();
        boolean result = boardController.boardWrite(content, writer, password);

        //3. 컨트롤러에게 전달 후 걀과를 받아 출력하기
        if( result ) {
            System.out.println("게시물 등록 성공");
        } else {
            System.out.println("게시물 등록 실패");
        }
    } // boardWrite end

    // 2. 게시물 출력 함수
    void boardPrint(){
        // 1. 컨트롤러에게 모든 게시물 정보를 요청

        // 2. 컨트롤러에게 전달받은 결과를 출력

    } // boardPrint end
}// class end
