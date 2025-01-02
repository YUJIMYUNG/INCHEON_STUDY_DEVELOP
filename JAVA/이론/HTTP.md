# HTTP

> 웹 통신 규약/ 규칙/ 약속 - 하이퍼텍스트(HyperText Transfer Protocol)
문자 타입의 자료만 통신이 가능하다. 즉 객체타입의 자료는 통신이 불가능하다.
> 

## 특징

1. 상태가 무상태 프로토콜이다. (상태가 없는 / 저장 기능이 없다.)
2. 독립적이다. 이전 요청과 현재 요청은 다르므로 서로 관련이 없다. 
3. TCP/IP 프로토콜의 종속되어 동작하며 port는 80을 사용한다.

## URL/ URI

- URL : 웹 주소, 네트워크 상의 자료가 어디에 있는지 알려주는 구약
- URI : 각종 자료들의 유일한 이름이나 위치를 표시하는 규약 ( URI + 자원 포함)

## HTTPS

> HTTP의 보안이 강화된 버전
> 

### 특징

1. 통신의 인증과 암호화를 위해 만들어진 프로토콜
2. 인증서 발급 업체로부터 인증서 발급을 받는다.
3. ex) 건강보험, 자동차보험처럼 홈페이지의 보험 체계

## HTTP Header ( HTTP 통신 정보 )

### HTTP METHOD

- http 이용한 통신 요청시 http 통신을 분류하는 함수
    1. GET : REST API 에서는 주로 자원을 요청할 때 사용한다. (R)
    2. POST : REST API 에서는 주로 자원을 저장 요청할 때 사용한다. (C)
    3. PUT : REST API 에서는 주로 자원 수정 요청할 때 사용한다.(U)
    4. DELETE : REST API 에서는 주로 자원 삭제 요청할 때 사용한다.(D)

### HTTP HOST

- http 이용한 통신 요청하는 서버의 URL 주소

### HTTP CONTENT-TYPE

- http 이용한 요청과 응답시 보내는 데이터 타입의 정보
    1. application/json
    2. text/html 등

### HTTP BODY

- http 이용한 보내는 데이터의 내용 / 본문
- POST/PUT 사용 가능
- GET/DELETE 사용 불가능

## HTTP 사용하는 소프트웨어, 라이브러리, 프레임워크

1. 브라우저(크롬, 엣지, 사파리 등)
2. fetch함수
3. spring web(톰캣 서버)등

## HTTP통신을 테스트 하는 방법

1. Talend API 확장프로그램 다운로드 링크

[Talend API Tester - Free Edition - Chrome 웹 스토어](https://chromewebstore.google.com/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=ko&pli=1)

1. 설치 후 확장프로그램 추가
2. talend api 사용하기
3. HTTP URL 테스트 하기
    
    ![image.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/44583fe6-6727-4cd4-a1a5-cae7ec7c61f5/8f460384-6fdd-4d33-91c7-ae894a827249/image.png)
    
    ```java
    package day53;
    
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.web.bind.annotation.*;
    
    // 1. 스프링 서버를 실행하기 위한 클래스
    @SpringBootApplication // 톰캣(웹) 서버를 세팅하는 annotation
    public class AppStart {
        public static void main(String[] args) {
            // 스프링 서버가 실행되면서 톰켓(웹)서버도 같이 실행된다.
            SpringApplication.run(AppStart.class);
        }
    }
    
    // 2. 외부로부터 HTTP 요청을 매핑(연결)하기 위한 컨트롤러 클래스
    @RestController // 현재 클레스의 HTTP컨트롤 클래스임을 지정한다.
    class day53Controller {
        @PostMapping("/day52")
        public String postMethod() {
            System.err.println("day53Controlle.postMethod");
            return "server connect POST OK";
        }
    
        @GetMapping("/day52")
        public String getMethod() {
            System.err.println("day53Controller.getMethod");
            return "server connect GET OK";
        }
    
        @PutMapping("/day52")
        public void putMethod() {
            System.err.println("day53Controller.putMethod");
        }
    
        @DeleteMapping("/day52")
        public void deleteMethod() {
            System.err.println("day53Controller.deleteMethod");
        }
    }
    ```
    
