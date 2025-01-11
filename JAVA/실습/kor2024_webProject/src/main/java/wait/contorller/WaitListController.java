package wait.contorller;

import wait.model.dto.WaitListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    @GetMapping("list.do")
    public ArrayList<WaitListDto> list(){
        ArrayList<WaitListDto> result = waitListService.list();

        return result;
    }
}

















