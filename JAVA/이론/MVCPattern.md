# MVC 패턴

> MVC ? 
소프트웨어 공학에서 사용하는 디자인 패턴 중 하나
> 

### 정의

프로그램을 깔끔하고 효율적으로 만들기 위해 사용되는 설계 방법

### 주요 역할

- Model : 데이터
- View : 사용자에게 보여주는 화면
- Controller : 사용자의 요청을 처리하고 모델과 뷰 연결

### 패턴 종류

1. MVC1 : Controller/View, Model 작업
    - Contoroller 와 view를 한 페이지에서 작성 ( ex - JSP )
    - Model
    - 문제점 : 프론트와 백엔드가 합쳐서 한 파일에 작업하므로 분업이 어렵다.
2. MVC2 : Controller, View, Model 작업
    - Controller
    - View
    - Model
3. Spring MVC2-Tire3 : 더 세분화해서 비지니스 로직을 만듦
    - Model : 서비스로받은 데이터베이스 로직 담당(JPA, Mybatis)
        - Dto : 서로 다른 레이어들간의 데이터 이동 객체 역할
        - Dao. : 데이터베이스 로직 담당
                  스프링 서버에서의 Dao 하지 않고 JPA를 권장한다.
    - View : resource 폴더 내 html/css/js, 템플릿(REACT, JSP, 타임리프)
        
                 스프링 서버에서의 view파일들은 모두 resource 안에 존재해야 한다.(설정파일로 경로변경 가능)
                 resource → static → HTML/CSS/JS
                 resource → templates → 타임리프      (*템플릿 파일들은 ‘templates’안에 존재)
        
    - Controller : RestController → 사용자의 HTTP요청과 응답을 담당
                      스프링 서버에서의 Controller는 @RestController 이나 @Controller 어노테이션 표시
    - Service : Controller와 Model의 사이로 자바의 비지니스(실질적인 처리) 로직 담당
                    스프링 서버에서의 Service는 @Service 어노테이션을 표시

## 스프링 웹 환경에서 기본적인 MVC 패턴 패키지 구성

```java
project명
	- src
		- main
			- java폴더 // 자바 코드 파일
				- contoller
				- model
					- dto / vo
					- repository
					- entity
				- service
				- AppStart // main함수를 갖는 @SpringbootApplication
			- resources 폴더 // 프론트엔드 코드 파일, 설정파일
				- static
				- templates
```