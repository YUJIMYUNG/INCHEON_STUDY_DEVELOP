package korweb.controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TaskController {


}
//class TaskStart3{
//    public static void main(String[] args) {
//        SpringApplication.run(TaskStart3.class, args);
//    }
//
//}
//@Controller
//class TaskController3{
//    @Autowired
//    TaskService3 taskService3;
//
//    @GetMapping("/aop")
//    public void aop() {
//        taskService3.enter1();
//    }
//}
//@Service
//class TaskService3 {
//    public void enter1() {
//        System.out.println("코로나 열 체크"); // 부가기능
//        System.out.println("식당 입장"); //비즈니스
//    }
//    public void enter2() {
//        System.out.println("코로나 열 체크"); //부가기능
//        System.out.println("학원 입장"); //비즈니스
//    }
//}
//
//@Aspect
//class TaskSecurity {
//    @Before("execution( * TaskService3.*(..)")
//    // 즉 TaskService3 클래스의 모든 메소드는 실행하기전에 아래 'securityCheck' 함수가 자동으로 실행된다.
//    public void securityCheck(){
//        System.out.println("코로나 열 체크");
//    }
//
//}
//
//
















