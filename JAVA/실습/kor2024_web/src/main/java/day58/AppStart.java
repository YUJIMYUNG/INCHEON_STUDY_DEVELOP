package day58;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        SpringApplication.run(AppStart.class);
    }
}

@Controller
class ViewController {
    @GetMapping("") // http url 정의
    public String index(){
        return "/day58/index.html";
    }

    @GetMapping("/layout")
    public String index2(){
        return "/day58/layout/index.html";
    }

    @GetMapping("/student")
    public String index3(){
        // 지정한 경로에 위치한 타임리프 템플릿을 렌더링하여 HTML로 반환
        // 해당 클래스에는 @RestController, @ResponsBody를 사용하면 안됨(문자가 반환됨)
        return "/day58/student/index.html";
    }

    // 학생 점수등록 페이지
    @GetMapping("/student/regist")
    public String regist(){
        return "/day58/student/regist.html";
    }

    // 학생 전체 점수보기 페이지
    @GetMapping("/student/view")
    public String view(){
        return "/day58/student/view.html";
    }

    // 학점수 개별 점수보기 페이지
    @GetMapping("/student/info")
    public String info(){
        return "/day58/student/info.html";
    }

    // 학생 점수 수정 페이지
    @GetMapping("/student/modify")
    public String modify(){
        return "/day58/student/modify.html";
    }

    // 학생 점수 삭제 페이지
    @GetMapping("/student/delete")
    public String delete(){
        return "/day58/student/delete.html";
    }
}
