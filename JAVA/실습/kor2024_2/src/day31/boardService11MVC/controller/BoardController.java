package day31.boardService11MVC.controller;

import com.mysql.cj.protocol.a.BooleanValueEncoder;
import day31.boardService11MVC.model.BoardDao;
import day31.boardService11MVC.model.BoardDto;

import java.util.ArrayList;

public class BoardController {
    //싱글톤
    private static BoardController boardController = new BoardController();
    private  BoardController(){};
    public static BoardController getInstance(){
        return boardController;
    }

    // 1. 게시물 등록 제어 함수
    public boolean boardWrite(String content, String writer, int pwd){

        //1. 다양한 데이터 검사 = 유효성 검사

        //2. 유효성 검사 통과 했으면 서로 다른 데이터를 하나(객체)로 만들기
        BoardDto boardDto = new BoardDto(content, writer, pwd);

        // 3. 입력받은 객체를 저장하기 위해 Dao 전달하고 결과를 응답받기

        return BoardDao.getInstance().boardWrite(boardDto);
    } // boardWrite end

    // 2. 게시물 출력 제어 함수
    public ArrayList<BoardDto> boardPrint(){
        // void : 메소드 호출시 반환되는 값이 없다는 뜻을 가진 키워드
        // - void 대신 여러개 게시물 반환 받고 싶어
        // * dao에게 게시물 전체출력 함수를 호출해서 결과를 받는다.
        // 1.  BoardDao 의 메소드를 호출하기 위해 객체 생성한다.

        // 2. dao에게 메소드를 호출하고 응답(모든게시물) 받기
        ArrayList<BoardDto> result =  BoardDao.getInstance().boardPrint();

        //3. dao에게 응답받은 결과를 view에게 응답하기
        return result; // - return 메소드가 종료되면서 바노한되는 값
    } // boardPrint end

    // 3. 게시물 삭제 함수
    public boolean boardDelete(int deleteNum){
        // 1. view에게 매개변수 값을 받는다.

        // 2. 원하는 데이터인지 유효성 검사

        // 3. DAO에게 삭제할 번호를 전달하여 DB처리 요청 후 결과를 받는다.
        boolean result = BoardDao.getInstance().boardDelete(deleteNum);

        // 4. dao에게 받은 결과를 view에게 전달한다.
        return result;
    } //boardDelete end

    //4. 게시물 수정 함수
    public boolean boardUpdate(BoardDto updateDto){
        //view 에게 받은 데이터를 dao에게 전달
        boolean result = BoardDao.getInstance().boardUpdate(updateDto);

        // dao에게 받은 결과를 view에게 전달
        return result;
    }
}
