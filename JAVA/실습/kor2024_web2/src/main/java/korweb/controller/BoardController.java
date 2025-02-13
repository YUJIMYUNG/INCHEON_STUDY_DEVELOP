package korweb.controller;

import korweb.model.dto.BoardDto;
import korweb.model.dto.PageDto;
import korweb.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BoardController {  @Autowired private BoardService boardService; //-- Board 서비스 객체 주입

    // [1] 게시물 쓰기
    @PostMapping("/board/write.do") // { "btitle": "qwe" , "bcontent" : "qwe" , "cno" : "1"  }
    public boolean boardWrite(@RequestBody BoardDto boardDto ){
        return boardService.boardWrite( boardDto);
    }

    // [2] 게시물 전체 조회 - 카테고리별
//    @GetMapping("/board/findall.do")
//    public List<BoardDto> boardFindAll( @RequestParam int cno ){ // 조회할 카테고리번호
//        return boardService.boardFindAll( cno );
//    }

    // [2] 게시물 전체 조회 - 카테고리별 + 페이징처리까지
//    @GetMapping("/board/findall.do")
//    public PageDto boardFindAll(@RequestParam int cno, @RequestParam int page){ // 조회할 카테고리번호
//        return boardService.boardFindAll( cno, page );
//    }

    // [2] 게시물 전체 조회 - 카테고리별 + 페이징처리 + 검색까지
    @GetMapping("/board/findall.do")
    public PageDto boardFindAll(@RequestParam int cno, @RequestParam int page, @RequestParam String key, @RequestParam String keyword){
        // key : 검색할 데이터의 속성명(btitle, bcontent)
        // keyword: 검색할 단어
        return boardService.boardFindAll( cno, page, key, keyword);
    }

    // [3] 게시물 특정(개별) 조회
    @GetMapping("/board/find.do")
    public BoardDto boardFind( @RequestParam int bno ){
        return boardService.boardFind( bno );
    }
    // [4] 게시물 특정(개별) 수정
    @PutMapping("/board/update.do") // { "bno": "1" , "btitle" : "qwe" , "bcontent" : "qwe" }
    public boolean boardUpdate( @RequestBody BoardDto boardDto ){
        return boardService.boardUpdate( boardDto );
    }
    // [5] 게시물 특정(개별) 삭제
    @DeleteMapping("/board/delete.do")
    public boolean boardDelete( @RequestParam int bno ){
        return boardService.boardDelete( bno );
    }


    // ======================= Reply ===========================
    // 6. 특정 게시물에 댓글 쓰기
    @PostMapping("/reply/write.do")
    public boolean replyWrite(Map<String, String> replyDto ) { // dto 클래스 다신에 Map컬랙션 활용
        return boardService.replyWrite(replyDto);
    }
    // 7. 특정 게시물의 댓글 전체조회
    @GetMapping("/reply/findall.do")
    public List<Map<String, String>> replyFindAll(@RequestParam int bno){
        return boardService.replyFindAll(bno);
    }
}
