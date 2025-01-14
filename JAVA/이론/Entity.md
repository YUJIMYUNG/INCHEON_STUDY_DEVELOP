# Entity

> **Entity란 ?** 
데이터베이스 테이블과 1:1로 매핑(연결) 되는 인스턴스(객체)
관점: 테이블 → 클래스, 레코드 → 엔티티(인스턴스)
즉) 클래스 1개당 테이블 1개, 인스턴스 1개당 레코드 1개

클래스를 만들고 엔티티를 설정하면 DB의 테이블을 생성한다는 의미와 같다.
같은 의미로 클래스로 인스턴스 생성하면 DB의 테이블 레코드를 생성한다.
> 

> 참고)
클래스 : 인스턴스를 만들기 위한 객체 설계도
인스턴스 : 클래스 기반으로 생성된 실체물
> 

## Entity를 정의하는 방법

- `@Entity` 어노테이션 추가
- 관례적으로 테이블 하나당 pk(식별자) 필드는 1개 이상어야 한다.
- `@Id`  : 해당하는 필드/ 멤버변수를 primary key 로 정의한다.
- `@Column` : 해당하는 필드/멤버변수를 테이블 열(속성/필드) 로 정의한다.
    - 자료형 타입을 자동으로 변환해준다.
        
        
        | 자바 | mysql |
        | --- | --- |
        | int | int |
        | boolean | bit |
        | byte | tinyint |
        | short | smallint |
        | char | char(1) |
        | float | float |
        | double | double |
        | long | bigint |
        | String | varchar(255) |
    - `@Column(columnDefinition  = “DB Type”)` : 자동변환되는 mysql type이 아닌 내가 설정해주고 싶은 type으로  설정한다.
    - `@Column( nullable = “true/false”)` : null 속성에 관한 정의
    - `@Column( unique = “true/false”)` : unique 속성에 관한 정의
    - **unsigned 에 관련된 어노테이션**
        
        PA/Spring Data JPA에서 unsigned 속성을 직접적으로 지정하는 기본 어노테이션은 없습니다. 하지만 @Column 어노테이션의 columnDefinition 속성을 사용해서 unsigned를 지정할 수 있습니다.
        
        예시 코드를 보여드리겠습니다:
        
        ```java
        java
        Copy
        @Entity
        public class Example {
            @Id
            @Column(columnDefinition = "BIGINT UNSIGNED")
            private Long id;
        
        // or
        
            @Id
            @Column(columnDefinition = "INT UNSIGNED")
            private Integer id;
        }
        
        ```
        
        주의할 점:
        
        1. 이 방식은 데이터베이스에 종속적입니다. MySQL에서는 작동하지만 다른 데이터베이스에서는 지원하지 않을 수 있습니다.
        2. JPA 명세에는 unsigned 데이터 타입이 포함되어 있지 않기 때문에, 실제 Java 객체에서는 signed 타입(Long, Integer 등)을 사용해야 합니다.
        3. 만약 데이터베이스의 unsigned 값이 Java의 signed 타입의 범위를 초과할 경우 오버플로우가 발생할 수 있으므로 주의가 필요합니다.
        
        데이터베이스의 이식성을 고려한다면, unsigned 대신 더 큰 범위의 signed 타입을 사용하는 것을 고려해볼 수 있습니다.
        
    

### 추가 Entity 관련 어노테이션

- `@Table` : 테이블의 열(속성/필드) 매핑 정의한다. 생략할 경우 자동으로 테이블명이 생성된다.
    - `@Table (name = “테이블명”)`
- `@GeneratedValue( strategy = GenerationType.IDENTITY)` : auto_crement, mysql의 제약조건 중 하나로서 자동번호를 부여한다.

## Entity와 테이블을 어떻게 처리할지 설정 옵션

- application.properties에 작성
    - `create` :  서버가 실행 될때마다 기존 테이블 삭제하고 새로운 테이블로 생성한다.
    - `update` :  서버가 실행 될때마다 기존 테이블을 유지하고 변경할 사항이 있을경우 자동 업데이트/생성 한다.
    - `none` : 개발자가 직접 수동 관리한다.(기본값)
    - `create`-drop : 서버가 종료될때 마다 테이블이 삭제된다.
    - `validate` : 서버가 실행 될때마다 엔티티와 데이터베이스 이맃 여부 확인, 수정/생성 하지 않는다.
    - 사용예 ) `spring.jpa.hibernate.ddl-auto = create`

## Entity를 조작할 인터페이스 정의

1. `@Repository` : 스프링 메모리에 객체를 생성하고 MVC패턴의 Repository 담당을 표시한다.
2. `extends JpaRepository<조작할 엔티티클래스명, PK필드의 자바타입>`