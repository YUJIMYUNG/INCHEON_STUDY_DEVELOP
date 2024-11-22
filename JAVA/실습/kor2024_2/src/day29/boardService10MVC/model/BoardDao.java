package day29.boardService10MVC.model;

import java.sql.*;
import java.util.ArrayList;

/*
    boardService8mvc 패키지를 복사하여 boardService10mvc으로 변경
    1. JAVA와 DB를 연동하는 JDBC 라이브러리 다운로드

 */

public class BoardDao {

    private Connection connection; // DB 연동 인터페이스 : DB 연동 결과를 가지고 있어서 DB조작이 가능한 인터페이스

    // 싱글톤
    private static BoardDao boardDao = new BoardDao();
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
    public static BoardDao getInstance() {
        return boardDao;
    }


    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // 1. 게시물 등록 접근 함수
    public boolean boardWrite(BoardDto boardDto){

        // 1. 게시물 등록 접근 함수
        // boardDB.add(boardDto);

        try{
            //1. connection.pepareStatement(DML(SQL) 작성) : 연동된 DB에 SQL을 서명할 준비하는 함수 * 일반예외
            PreparedStatement ps = connection.prepareStatement("insert into board(bcontent,bwriter,bpwd)values('여기는JAVA','유재석','1234')");

            //2. 서명된 SQL 실행
            ps.execute();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    // 2. 게시물 출력 접근 함수
    public ArrayList<BoardDto> boardPrint(){
        return boardDB;
    }
}
