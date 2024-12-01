package day31.boardService11MVC.view;

import day31.boardService11MVC.controller.BoardController;
import day31.boardService11MVC.model.BoardDto;

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
            System.out.print("1. 게시물 등록 2. 게시물 출력  3.게시물 삭제: 4.게시물 수정 선택 ");
            int choose = scan.nextInt();

            if(choose == 1){
                boardWrite();
            } else if(choose == 2) {
                boardPrint();
            } else if(choose == 3) {
                boardDelete();
            } else if(choose == 4) {
                boardUpdate();
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
            System.out.printf("게시물 번호 : %s, 내용 : %s, 작성자 : %s\n",result.get(i).getNum(), result.get(i).getContent(), result.get(i).getWriter());
        }
    } // boardPrint end


    // 3. 게시물 삭제 함수
    void boardDelete(){
        // 1. 삭제할 게시물 번호 입력받기
        scan.nextLine();
        System.out.print("삭제할 게시물 번호");
        int deleteNum = scan.nextInt();

        // 2. view 는 실질적인 처리하는 곳이 아니다.(입출력)
            // - 삭제는 매개변수 : 삭제할 번호, 삭제는 반환값 : 성공=true/실패=false
        boolean result = BoardController.getInstance().boardDelete(deleteNum);

        // 3. controller 처리후 응답한 결과를 반환된 결과 출력
        if(result) {
            System.out.println("게시물 삭제 완료");
        }else {
            System.out.println("게시물 삭제 실패");
        }
    }// boardDelete() end

    //4. 게시물 수정 함수
    void boardUpdate(){
        //1. 수정할 게시물 번호, 수정할 내용 입력받기
        System.out.print("수정할 게시물 번호");
        int updateNum = scan.nextInt();
        scan.nextLine();
        System.out.print("수정할 내용");
        String updateContent = scan.nextLine();

        // 수정 게시물 객체
        BoardDto updateDto = new BoardDto(updateNum, updateContent);

        // 2.controller에 전달
        boolean result = BoardController.getInstance().boardUpdate(updateDto);

        // 3. 결과 출력
        if(result) {
            System.out.println("게시물 수정 완료");
        } else {
            System.out.println("게시물 수정 실패");
        } // if-else end
    }// boardUpdate end
}// class end
