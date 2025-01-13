# ORM

> **ORM이란 ?** 
Object Relational Mapping의 약자로 객체지향 프로그래밍에서 사용하는 객체와 관계형 데이터베이스에서 사용하는 테이브로가 매핑(연결) 해주는 기술이다.
즉, 자바 객체와 관계형 데이터베이스 테이블간 매핑을 자동으로 처리해주는 기술이다.
> 

## 목적

- 개발자에게 조금 더 편리성을 제공하기 위해 만들어진 기술

## Hibernate

> **Hibernate이란 ?**
자바에서 ORM을 구현한 프레임워크로 가바 객체를 관계형 데이터베이스에 쉽게 저장/조회할 수 있도록 도와주는 라이브러리이다.
> 

### 목적

- sql 쿼리를 자동으로 생성해주기 때문에 편리하게 사용 가능하다.
- 개발자가 직접 SQL을 작성하지 않아도 된다.
- 간단한 쿼리는 자동이지만, 복잡한 쿼리는 결국 직접 작성해야한다.
- 자동으로 타입을 변환해주는 기능을 제공한다.
- JDBC(Dao)의 복잡함을 해결하고 간결한 코드를 이용하여 제공받은 라이브러리로 빠른 개발이 가능하다.

## JPA

> JPA란 ? 
Java Persistence API의 약자로 자바에서 ORM을 사용할 때 사용하는 표준 API
JPA는 자바에서 객체 관계 매핑(연결)을 어떻게 처리할지 정의한 규약/규칙
→ Hibernate 는 구현체, JPA는 인터페이스 : JPA 이용하여 Hibernate를 사용한다.
> 

### 목적

- JPA를 이용하여 SQL 생성, 트랙잭션 관리, 엔티티 정의 등을 관리할 수 있다.

### JPA 사용할 준비

1. build.gradle 파일에 JPA 의존성 추가
    
    ```java
     implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    ```
    
    - runtimeOnly ‘com.mysql:mysql-connector-j’와 같이 추가함
2. JPA가 매핑할 DB 정보를 설정해야 한다.
    - 설정 파일의 이름이 정해져 있다.
    - resource 폴더 → [application.properties](http://application.properties) 으로 파일 생성
3. [application.properties](http://application.properties) 내용 작성
    
    ```sql
    # .properties 파일의 주석하는 방법 -> #
    
    # 1. JDBC : Java Database Connection
    #  - 1. Driver 클래스 로드하기
    #.      oracle일 경우 : oracle.jdbc.driver.OracleDriver
    spring.datasource.driverClassName = com.mysql.cj.jdbc.Driver
    
    #  - 2. DB Server URL 작성
    #       DB 생성 - create database jpaexample;
    spring.datasource.url = 연동 서버 url
    #  - 3. 연동할 DB Server username
    spring.datasource.username =유저명
    
    #  - 4. 연동할 DB Server password
    #       주의할점 : = 뒤에 띄어쓰기 하면 안됨
    spring.datasource.password =유저비번
    ```
    

### ORM - Hibernate, JPA, DB의 관계

1. ORM : 객체와 테이블간의 매핑 처리 기술
2. Hibernate : ORM 기술의 구현체이며, 프레임워크
3. JPA : ORM 기술의 구현체를 조작하는 인터페이스, 프레임워크
4. DB : 실제 데이터가 저장된 서버