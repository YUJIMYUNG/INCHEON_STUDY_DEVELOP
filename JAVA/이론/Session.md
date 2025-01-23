# Session

## 웹서버

> **클라이언트와 서버 간의 HTTP를 이용한 요청과 응답을 반환하는 프로그램**
> 

### 종류

- Apache : C기반의 서버 프로그램으로 정적페이지를 지원한다.
- Tomcat : Java기반의 서버 프로그램으로 동적 페이지를 지원한다.
- Apache Tomcat : 정적페이지와 동적페이지를 모두 지원한다.

### 통신 흐름

클라이언트(사용자)   ———>  HTTP request ———> 웹서버(스프링:톰캣)

브라우저(크롬) < ——— HTTP response ———— @xxxMapping @Response 등등

## Session

> Spring boot 프레임워크를 사용하면 자동으로 tomcat 내장 서버가 실행된다.
**tomcat(톰캣) 서버에 데이터를 저장하고 관리할 수 있게 제공하는 기능**
> 

### 목적

1. 상태(데이터) 관리
2. 인증 / 권한
3. 클라이언트에 노출이 되지 않음

### 주 사용처

- 데이터베이스에 저장하지 않고 실시간으로 처리하는 데이터 혹은 보안이 중요한 데이터들
1. 로그인 상태 유지
2. (비회원제) 장바구니 기능
3. 사용자 설정값 : 자동로그인, 테마 등
4. 실시간 처리

### 세션 객체

1. `HttpServletRequest` : 서블릿(톰캣) 안에 데이터/정보 요청 객체
2. `.getSession()` : 서블릿(톰캣) 안에 세션객체를 호출하는 함수

### 세션에 정보 저장 / 출력 / 삭제

- 저장하기
    1. `@Autowried pricate HeetpServletRequest request;`
    2. `HttpSession httpSession = request.getSession();`
    3. `httpSession.setAttribute("속성명", 값 );`
        - 내가 새로운 속성명으로 값을 추가 했다면 그 값 타입은 자동으로 Object 타입으로 변한다.
- 꺼내기
    1. `@Autowried pricate HeetpServletRequest request;`
    2. `HttpSession httpSession = request.getSession();`
    3. `httpSession.getAttribute("조회할 속성명");`
        - 내가 새로운 속성명으로 값을 호출 했다면 그 값 타입은 자동으로 Object 타입으로 변한다. (타입 변환이 필요함)
- 삭제
    1. `@Autowried pricate HeetpServletRequest request;`
    2. `HttpSession httpSession = request.getSession();`
    3. `httpSession.remove("삭제할 속성명");`

> 세션에 저장된 모든 정보들을 Object 타입으로 저장된다.
- Object 클래스/타입은 자바의 최상위 클래스로 모든 인스턴스들을 저장할 수 있는 타입이다.
>