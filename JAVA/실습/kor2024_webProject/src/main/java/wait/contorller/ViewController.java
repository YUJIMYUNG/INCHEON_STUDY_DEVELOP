package wait.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @GetMapping("")
    public String main(){
        return "/wait/index.html";
    }


    @GetMapping("/regist")
    public String regist(){
        return "/wait/regist.html";
    }

    @GetMapping("/list")
    public String list(){
        return "/wait/list.html";
    }

    @GetMapping("/delete")
    public String delete(){
        return "/wait/delete.html";
    }

    @GetMapping("/mypage")
    public String mypage(){
        return "/wait/mypage.html";
    }
}
