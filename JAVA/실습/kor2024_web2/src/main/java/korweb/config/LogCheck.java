package korweb.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect //AOP를 설정하는 어노테이션 주입
@Component // 스프링 컨테이너에 빈 등록
public class LogCheck {

    // +StudentService 클래스내 모든 메소드가 실행되기전에 자동으로 부가 기능 실행
    @Before("execution( * korweb.service.StudentService.*(..) )")
        // 첫번쨰 * : 모든 반환타입의 메소드
        // korweb.service.StudentService : 클래스가 위치한 경로(src->main->java 이후)
        // 두번째 * : 앞에 있는 클래스내 모든 메소드
        // (..) : 메소드들의 매개변수 타입 뜻, 모든타입
    public void logBefore() {
        System.out.println("StudentService 발동");
    }

//
//    @After()
//
//    @Around()
}
