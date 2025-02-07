package korweb.service;

import korweb.model.dto.BoardDto;
import korweb.model.entity.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardEntity boardEntity;

    // 1. 게시물 쓰기
    public boolean boardWrite (@RequestBody BoardDto boardDto) {
        return false;
    }

    // 2. 게시물 전체 조회
    public List<BoardDto> boardFindAll() {
        return null;
    }

    // 3. 특정 게시물 조회
    public List<BoardDto> boardFind(@RequestParam int bno){
        return null;
    }

    // 4. 게시물 수정
    public boolean boardUpdate(@RequestBody BoardDto boardDto){
        return false;
    }

    // 5. 게시물 삭제
    public boolean boardDelete(@RequestParam int bno){
        return false;
    }
}
