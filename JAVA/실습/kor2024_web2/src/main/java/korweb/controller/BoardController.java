package korweb.controller;

import korweb.model.dto.BoardDto;
import korweb.service.BoardService;
import org.hibernate.annotations.WhereJoinTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    BoardService boardService;

    // 1. 게시물 쓰기
    @PostMapping("/board/write.do")
    public boolean boareWrite (@RequestBody BoardDto boardDto) {
        return boardService.boardWrite(boardDto);
    }


    // 2. 게시물 전체 조회
    @GetMapping("/board/findall.do")
    public List<BoardDto> boardFindAll() {
        return  boardService.boardFindAll();
    }

    // 3. 특정 게시물 조회
    @GetMapping("/board/find.do")
    public List<BoardDto> boardFind(@RequestParam int bno){
        return boardService.boardFind(bno);
    }

    // 4. 게시물 수정
    @PutMapping("/board/update.do")
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        return boardService.boardUpdate(boardDto);
    }

    // 5. 게시물 삭제
    @DeleteMapping("/board/delete.do")
    public boolean boardDelete(@RequestParam int bno){
        return boardService.boardDelete(bno);
    }
}
