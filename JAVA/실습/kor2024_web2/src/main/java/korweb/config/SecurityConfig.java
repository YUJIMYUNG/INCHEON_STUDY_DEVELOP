package korweb.config;

import korweb.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // 스프링 컨테이너의 빈 등록
public class SecurityConfig {

    @Autowired
    MemberService memberService;

    // 1. 시큐리티의 필터 정의하기
    @Bean // 필드 또는 메소드에 빈 등록하는 방법
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        // 3. HTTP URL 요청에 따른 부여된 권한/상태 지원 허가 제한
        http.authorizeHttpRequests((httpReq) -> {
            // 3-1. 모든 HTTP 요청에 '/**'(모든 url뜻).anMatcher('http'경로).permiAll() : 지정한 경로에는 누구나 접글할 수 있다.
            // 3-2. 글쓰기페이지(board/write)에는 로그인된 회원만 접근할 수 있다.
            // 3-3. 채팅(chat) 에는 로그인회원이면서 Role 이 USER 인 회원만 접근할 수 있다.
            // 3-4. 관리자페이지(admin)에는 로그인회오원이면서 Role이 admin이거나 temp1 회원만 접근할 수 있다.
            httpReq
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/board/write")).authenticated() // 인증(로그인) 모든 회원 접속 가능
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/chat")).hasRole("USER") // 로그인도니 모든 회원 접속 가능
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/api1")).hasAnyRole("GENERAL") // 일반 회원만 접속
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/api2")).hasAnyRole("OAUTH")// oauth 회원만 접속
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/admin")).hasAnyRole("ADMIN", "TEAM1") // ADMIN 또는 TEAM1만 접속 가능
                    .requestMatchers(AntPathRequestMatcher.antMatcher("/**")).permitAll(); // 그 외 모든 접속자 허용
        });

            // * 403 (페이지 접근 권한이 없음) 에 대한 에러페이지에 대한 처리
        http.exceptionHandling( (e) -> {
            e.accessDeniedHandler( ((request, response, accessDeniedException) -> {
                response.sendRedirect("/error403"); //URL 반환
            })); // 403 에러 핸들러
        });



        // 4. CSRF : post/put (BODY) 요청을 금지, 특정한 URL만 post/put 가능하도록 수동 허용
        // 개발: CSRF 사용안함, 개발 환경에서는 끄고 사용하는 경우가 많다.
        http.csrf(AbstractHttpConfigurer :: disable ); // csrf끄기 -> post/put 사용할 수 있음
        // 배포/운영 : 특정한 URL 수동으로 허용 , 운영 환경에서는 안전하게 몇몇개의 REST만 허용한다.
        // http.csrf( csrf -> csrf.ignoringRequestMatchers("csrf예외할URL") );
        // http.csrf( csrf -> csrf.ignoringRequestMatchers("/member/signup.do") ); // 회원가입 POST 예외

        // 5. 시큐리티 로그인 (시큐리티에서 제공하는 로그인 기능 커스텀)
        // JSON 형식이 아닌 Form 형식으로 지원
        http.formLogin( loginform ->
                loginform
                        .loginPage("/member/login")             // 로그인할 view page url 정의
                        .loginProcessingUrl("/member/login.do") // 로그인을 처리할 URL 정의 : POST 방식
                        .usernameParameter("mid")               // 로그인에 사용할 id 변수명
                        .passwordParameter("mpwd")              // 로그인에 사용할 password 변수
                        //.defaultSuccessUrl("/")                 // 로그인 성공시 이동할 page url 정의
                        //.failureUrl("/member/login")     // 로그인 실패시 이동할 page url 정의
                        // fetch/axios 처리에서는 아래와같이 사용
                        .successHandler((request, response, exception) -> {
                            System.out.println("로그인 성공!!!");
                            response.setContentType("application/json");    // 응답 방식을 JSON으로 변경
                            response.getWriter().println("true");           //JSON 형식의 true 응답
                        })
                        .failureHandler((request, response, exception) -> {
                            System.out.println("로그인 실패!!!");
                            response.setContentType("application/json");
                            response.getWriter().println("false");
                        })
        );

        // 6. 시큐리티 로그아웃 (시큐리티에서 제공하는 로그아웃 기능 커스텀)
            // 1). 시큐리티 설정클래스에서 로그인 관련된 설정 코드를 작성한다.
        http.logout(logoutform ->
                logoutform
                        .logoutUrl("/member/logout.do")          // 로그아웃 요청할 url : GET 방식
                        .logoutSuccessUrl("/")                  // 로그아웃 성공시 이동할 page url 정의
                        .invalidateHttpSession(true)            // 로그아웃 성공시 (로그인) 세션 초기화

        );
            // 2).로그인시 암호화된 패스워드를 검증할 암호화 클래스

        // 7. 로그인을 처리할 서비스 객체 정의
        http.userDetailsService(memberService);

        // 8. 시큐리티에서 Oauth2 로그인 페이지와 (커스텀/오버라이딩/재정의) 서비스 정의
        http.oauth2Login(oauth2Login -> {
            oauth2Login
                    .loginPage("/member/login")
                    .userInfoEndpoint(userinfo -> {
                        userinfo.userService(memberService); // oauth2에서 로그인 성공시 유저 정보를 받을 객체 정의
                    });
        });

        // 2. http 객체를 빌드/실행하여 보안 필터 체인을 생성
        return http.build();
    }


    // 2. 암호화 : 시큐리티가 회원 패스워드 검증(로그인)할 때 사용할 암호화 객체
    // 개발자가 직접 암호화를 비교하지 않고, 시큐리티가 자동으로 암호화를 비교한다.(로그인처리 자동)
    @Bean // 스프링 컨테이너에 메소드 등록, 암호화해서 사용된 클래스를 그대로 정의한다./ PasswordEncoder : 시큐리티가 로그인할 때 사용할 암호화 인코딩 객체
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }




}
