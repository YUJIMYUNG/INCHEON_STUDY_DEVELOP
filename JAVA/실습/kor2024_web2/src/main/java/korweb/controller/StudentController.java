package korweb.controller;

import korweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // 스프링 컨테이너에 빈(인스턴스) 등록, HTTP의 요청/응답 처리
@RequestMapping("/students") // 해당 클래스내 메소드들의 공통 URL 정의
public class StudentController {

    @Autowired private StudentService studentService;

    // 1. 학생 점수 등록
    @PostMapping("/save")
    public int save(@RequestBody Map<String, Object> map){
        System.out.println("StudentController.save");
        System.out.println("map = " + map);
        return studentService.save(map);
    }

    // 2. 학생 전체 조회
    @GetMapping("/list")
    public List< Map<String, Object> > findAll() {
        System.out.println("StudentController.findAll");
        System.out.println();
        return studentService.findAll();
    }

    // 3. 특정 점수 이상의 학생 조회
    @GetMapping("/scores")
    public List<Map<String, Object>> findStudentScores(@RequestParam int minKor,@RequestParam int minMath){
        return studentService.findStudentScores(minKor, minMath);
    }

    // 4. 여러명의 학생을 한 번에 등록하기
    @PostMapping("/all")
    public boolean saveAll(@RequestBody List<Map<String, Object>> list){
        return studentService.saveAll(list);
    }
}
