package wait.contorller;

import org.springframework.web.bind.annotation.*;
import wait.model.dto.WaitListDto;
import org.springframework.beans.factory.annotation.Autowired;
import wait.model.response.WaitListResponse;
import wait.service.WaitListService;

import java.util.ArrayList;

@RestController
public class WaitListController {

    @Autowired private WaitListService waitListService;

    //1. 대기명단 등록
    @PostMapping("/regist.do")
    public int regist(@RequestBody WaitListDto waitListDto) {
        System.out.println("WaitListController.regist");
        System.out.println("waitListDto = " + waitListDto);

        int result = waitListService.regist(waitListDto);

        return result;
    }

    //2. 대기명단 목록
    @GetMapping("/list.do")
    public WaitListResponse list(){
        WaitListResponse result = waitListService.list();

        return result;
    }

    //3. 특정 대기명단 개별 삭제
    @DeleteMapping("/delete.do")
    public boolean delete(@RequestParam int gno){
        boolean result = waitListService.delete(gno);

        return result;
    }

    //4. 마이페이지(내 전화번호 입력하면 현재 예상시간 출력)
    // 대기명단에 없으면 존재하지 않는 번호입니다.
    // 예상시간은 대기명단 한개마다 5분씩 부여
    // 만약 3개 대기명단 존재하면 대기예상시간은 15분
    @GetMapping("/mypage.do")
    public ArrayList<WaitListDto> mypage(@RequestParam String gphone){
        ArrayList<WaitListDto> result = waitListService.mypage(gphone);

        return result;
    }
}

















