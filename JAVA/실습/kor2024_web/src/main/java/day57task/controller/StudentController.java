package day57task.controller;

import day57task.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    // 만든 클래스 객체/인스턴스를 주세요
    @Autowired private StudentService studentService;


}
