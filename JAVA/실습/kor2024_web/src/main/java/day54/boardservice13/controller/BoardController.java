package day54.boardservice13.controller;

import day54.boardservice13.model.dao.BoardDao;
import day54.boardservice13.model.dto.BoardDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


// ==================== 콘솔 ===============
//public class BoardController {
    // 싱글톤 -
//    private BoardController(){};
//    private static BoardController instance = new BoardController();
//    public static     BoardController getInstance(){
//        return instance;
//    }

// ================== 웹 ================
@RestController
public class BoardController {
    // 1. 게시물 쓰기 C : POST
    @PostMapping("/write")
    public boolean write(@RequestBody BoardDto boardDto) { // body 데이터를 받기 위한 @RequestBody
        System.out.println("boardDto = " + boardDto);// soutm : 메소드명 출력함수 자동완성
        System.out.println("boardDto = " + boardDto);// soustp : 메소드명 매개변수 출력함수 자동완성
        boolean result = BoardDao.getInstance().write(boardDto);
        return result;
    }

    // 2. 게시물 전체 조회 R : GET
    @GetMapping("/findall")
    public ArrayList<BoardDto> findAll() {
        ArrayList<BoardDto> result = BoardDao.getInstance().findAll();
        return result;
    }

    // 3. 게시물 개별 조회 R : GET
    @GetMapping("/findid")
    // test : tealend api tester : GET http://localhost:8080/findid?bno=조회할번호
    public BoardDto findId(@RequestParam int bno) {
        System.out.println("BoardController.findId");
        System.out.println("bno = " + bno);
        BoardDto result = BoardDao.getInstance().findId(bno);
        return result;
    }

    // 4. 게시물 수정
    // 과제코드
//    @PutMapping("/update")
//    public boolean update(@RequestParam int bno, @RequestBody BoardDto updateBoardDto){
//        System.out.println("BoardController.update");
//        System.out.println("updateBoardDto = " + updateBoardDto);
//        boolean result = BoardDao.getInstance().update(bno, updateBoardDto);
//
//        return result;
//    }

    // 수업코드
    @PutMapping("/update")
    public boolean update(@RequestBody BoardDto updateBoardDto){
        System.out.println("BoardController.update");
        System.out.println("updateBoardDto = " + updateBoardDto);
        boolean result = BoardDao.getInstance().update(updateBoardDto);

        return result;
    }


    // 5. 게시물 삭제
    @DeleteMapping("/delete")
    public boolean delete(@RequestParam int bno){
        System.out.println("BoardController.delete");
        System.out.println("bno = " + bno);
        boolean result = BoardDao.getInstance().delete(bno);

        return result;
    }

}
