package day30.boardService10MVC.model;

import day22.Board;

import java.sql.*;
import java.util.ArrayList;

public class BoardDao {

    //JDBC 인터페이스
    private Connection conn; // 연동된 결과의 연동 객체를 조작할 인터페이스

    // 싱글톤
    private static BoardDao boardDao = new BoardDao();

    // 생성자에서 DB연동 코드 작성
    private BoardDao(){

        try {
            //1.
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2.
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb1125", "root", "auddnjs20");

            //3. test
            System.out.println("BoardDB Connection OK");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("BoardDB Connection Fail");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("BoardDB Connection Fail");
        }
    };

    public static BoardDao getInstance(){
        return boardDao;
    }


    // 1. 게시물 등록 접근 함수
    public boolean boardWrite(BoardDto boardDto){

        try {
            //1. SQL 작성 : SQL 그대로 작성하되 데이터가 들어가는 자리는 ? 으로 작성
            String sql = "insert into board(content, writer, pwd)values(?,?,?)";

            //2. 작성한SQL를 DB연동객체에 기재한다.
            //  - 연동된 객체로부터 SQL 기재해서 준비된 객체를 PreparedStatment 인터페이스에 대입한다.
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. 기재된 SQL의 매개변수에 값을 대입한다.
            // - pssetString(?순서번호, 대입할 데이터)
            ps.setString(1, boardDto.getContent()); // sql 첫번째 데이터 ? 에 입력받은 게시물 내용
            ps.setString(2, boardDto.getWriter()); // sql 두번째 데이터 ? 에 입력받은 게시물 작성자
            ps.setInt(3, boardDto.getPwd()); // sql 세번째 데이터 ? 에 입력받은 게시물 비번

            //4. 기재된 SQL 실행 excute:실행하다, Update : 최신화하다
            ps.executeUpdate();

            //5. 성공했을 때 true 반환
            return true;
        } catch (SQLException e){
            e.getMessage();
            System.out.println("게시물 등록시 예외발생");
        }

        return false;
    }

    // 2. 전체 게시물 출력 접근 함수
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> list = new ArrayList<>(); // 조회된 레코드들을 객체화해서 저장할 리스트객체 선언

        try {
            //1. SQL 작성
            String sql = "select * from board";

            //2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql); // 기재할 SQL 준비

            //3. SQL 조작, excuteQuery() : sql 실행 결과 조작하는 resultSet 객체 반환
            //4. SQL 실행
            ResultSet rs = ps.executeQuery();

            //5. SQL 결과
            while(rs.next()) { // rs.next(): 조회 결과에서 다음 레코드로 이동
                // 만약에 겨로가 레코드가 3개 존재하면 rs.next() 3번 실행된다.
                // 해석 - 조회 결과 마지막 레코드까지 하나씩 레코드 이동
                // 6. 레코드를 읽어서 각 필드별 데이터를 호출한다.
                // rs.getXXX("필드명") : 지정한 필드명의 값 타입에 맞게 값 반환
                int num = rs.getInt("num");
                String content = rs.getString("content");
                String writer = rs.getString("writer");
                int pwd = rs.getInt("pwd");

                // 7.각 레코드의 호출된 필드값들 객체화 --> DTO 생성
                BoardDto boardDto = new BoardDto(content, writer, pwd);

                // 8. 반복문 한번에 레코드 한개를 dto로 변환
                list.add(boardDto);
            }// while end
        }catch (SQLException e){
            e.getMessage();
            System.out.println("게시물 출력시 예외발생");
        } // try-catch end

        // 9. 구성한 리스트 객체 반환
        return list;
    }
}
