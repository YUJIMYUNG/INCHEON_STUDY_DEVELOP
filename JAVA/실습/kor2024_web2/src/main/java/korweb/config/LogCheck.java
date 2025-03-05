package korweb.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect //AOP를 설정하는 어노테이션 주입
@Component // 스프링 컨테이너에 빈 등록
public class LogCheck {

    // +StudentService 클래스내 모든 메소드가 실행되기전에 자동으로 부가 기능 실행 + 매개변수
    //1. @Before
//    @Before("execution( * korweb.service.StudentService.*(..) ) && args(param)") // args : arguments:인수
//        // 첫번쨰 * : 모든 반환타입의 메소드
//        // korweb.service.StudentService : 클래스가 위치한 경로(src->main->java 이후)
//        // 두번째 * : 앞에 있는 클래스내 모든 메소드
//        // (..) : 메소드들의 매개변수 타입 뜻, 모든타입
//    public void logBefore(Object param) { // Object : 여러 매소드들의 인수값 타입을 대입받기 위해 슈퍼클래스인 Object타입 정의
//        System.out.println("[AOP] StudentService 발동");
//        System.out.println("[AOP] 매개변수" + param);
//    }
//
//
////    2. @AfterReturning
//    //  *StudentService 클래스내 모든 메소드가 정상실행 종료 했을 때 자동으로 부가 기능 실행
//    @AfterReturning(value = "execution( * korweb.service.StudentService.*(..) )", returning = "result")
//    public void logReturn(Object result){
//        System.out.println("[AOP] StudentSevice 종료 ");
//        System.out.println("[AOP] 반환값" + result);

    //   3. @Around()
    @Around("execution( * korweb.service.StudentService.*(..) )")
    public Object logAround (ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println(joinPoint.getArgs());// 발동된 메소두의 인수 반환
        System.out.println(joinPoint.getSignature()); // 발동된 메소드의 선언부(반환타입 함수명 매개변수 정보) 반환/가져오기

        // 1. 발동된 메소드의 함수명
        System.out.println("[AOP] 현재 실행된 서비스명 : " + joinPoint.getSignature());
        // 2. 발동된 메소드의 인수값, Arrays.toString(배열타입의변수명) : 배열내 값들을 문자열로 반환
        System.out.println("[AOP] 현재 실행된 서비서/기능의 매개변수의 인자 : " + Arrays.toString(joinPoint.getArgs()));
        // 3. 매소드를 발동하고 리턴값 반환
        Object result = joinPoint.proceed();
        System.out.println("[AOP] 현재 실행된 서비스의 반환" + result);

        // 발송한 메소드의 결과값을 그대로 반환
        return result;
    }
}





