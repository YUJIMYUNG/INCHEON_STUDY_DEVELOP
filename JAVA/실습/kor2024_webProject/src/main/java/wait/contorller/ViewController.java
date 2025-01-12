package wait.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/regist")
    public String regist(){
        return "/regist.html";
    }

    @GetMapping("/list")
    public String list(){
        return "/list.html";
    }

    @GetMapping("/delete")
    public String delete(){
        return "/delete.html";
    }

    @GetMapping("/mypage")
    public String mypage(){
        return "/mypage.html";
    }
}
