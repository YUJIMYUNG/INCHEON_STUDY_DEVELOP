# JDBC


> JDBC란?
Java Database Connect : 자바 데이터베이스 연동
> 

## 연동하는 방법

1. 현재 java 프로젝트의 jdbc의 라이브러리 등록하기
    1. mysql-connector-j-9.1.0.jar (다운로드)
    2. 현재 java 프로젝트내 임의 폴더내 넣기
    3. 프로젝트내 넣어둔(복사한) mysql-connector-j-9.1.0.jar 파일 오른쪽 클릭 → 가장 하단에 [라이브러리 추가] 클릭
2. MVC
    1. DAO(Data access Object) : 데이터 접근 객체, 파일/DB에 접근하여 실제 데이터를 가져올때 사용 
    2. DTO(Data Transfer Object) : 데이터 이동 객체, 파일/DB 에 접근하여 가져온 데이터를 VIEW 까지 이동하기 위해 사용
    3. VO(Value Object) : 값 자체, (읽기모드 / setter없음)
3. DAO 에서 DB 연동(Mysql)
    
    ```java
     private BoardDao(){
            // DB 연동시 필요한 코드 두줄
            try {
                // 1. 외부라이브러리(JDBC) 폴더 내 com 폴더 -> mysql폴더 -> cj폴더 -> jdbc폴더 -> Driver 클래스 호출 * 일반예외
                Class.forName("com.mysql.cj.jdbc.Driver");  // forName() 특정 클래스를 호출하는데 사요오디는 함수
                // 만일 클래스가 존재하지 않으면 어떻게 해야하는지 일반예외에서 처리
    
                //2. DB연동 인터페이스 만들기 : DriverManager.getConnection("MYSQLSERBER_URL/DB명", "계정명", "비밀번호");
                // DriverManager.getConnection() : DB SERVER 와 연동을 성공 했을 때 연동된 결과의 객체를 반환 * 일반예외
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1122", "root", "auddnjs20");
    
                //3. 확인
                System.out.println("3) DB 연동 성공");
    
                // 연동에 실패하는 이유
                // 1. 프로젝트에 jdbc 라이브러리 등록을 안했다
                // 2. db연동 url 경로문제
    
            } catch (ClassNotFoundException e){
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        };
    ```
    

## JDBC 핵심 인터페이스

### Connection 인터페이스

- DB와 연동 성공한 객체 정보를 가지고 조작/기능/메소드를 제공하는 인터페이스
    - `Connection conn = DriverManager.getConnection( mysql )`
    - `Connection conn = DriverManager.getConnection( oracle )`
    - `Connection conn = DriverManager.getConnection( mariaDB )`
    - 서로 각 다른 DB회사에서 제공하는 클래스(만든 사람이 다르므로 클래스가 다름)은 다르다.
    - → 하지만 하나의 인터페이스로 서로 다른 회사의 클래스를 사용한다.
- `conn.prepareStatement(SQL 문자열)` : 작성한 SQL을 배개변수로 전달하면 기재한 SQL을 조작 가능
    
    

### PreparedStatement 인터페이스

- 기재된 SQL을 조작/메소드 제공하는 인터페이스
- ps.setXXX ( ? , value) : 기재된 ?에 매개변수를 대입하는 함수
    - XXX : 데이터 타입
    - ? : 기재된 SQL의 순서 번호
    - value : 앞 매개변수 ?에 대한 값
- `ps.excuteUpdate()` : 현재 기재된 SQL을 실행하는 함수
- `ps.excuteQuert()` : 현재 기재된 SQL을 실행하고 조회된 결과를 반환하는 함수

### ResultSet 인터페이스

- 실행된 SQL 조회 결과를
- `rs.next()` : 조회된 결과의 다음 레코드 이동하는 함수, 다음 레코드가 존재하면 true, 존재하지 않으면 false
- `rs.getXXX(”필드명”)` :현재 조회중인 레코드의 지정한 필드명의 값 호출
    - `rs.getInt(”num”)` : “num”필드값을 가진 데이터 호출
    - `rs.getString(”content”)` : “content” 필드값을 가진 데이터 호룿 ㄹ