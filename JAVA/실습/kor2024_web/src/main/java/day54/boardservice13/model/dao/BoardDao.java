package day54.boardservice13.model.dao;

import day54.boardservice13.model.dto.BoardDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDao {
    // 연동 인터페이스
    private Connection conn;
    // 싱글톤
    private BoardDao(){
        try{
            // DB연동
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0102", "root", "auddnjs20");
        } catch (Exception e){
            e.getMessage();
        }
    };
    private static BoardDao instance = new BoardDao(){};
    public static BoardDao getInstance() {
        return instance;
    };

    // 1. 게시물 쓰기
    public boolean write(BoardDto boardDto){
        try{
            String sql = "insert into board(btitle, bcontent, bwriter, bpwd) values(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, boardDto.getBtitle());
            ps.setString(2, boardDto.getBcontent());
            ps.setString(3, boardDto.getBwriter());
            ps.setString(4, boardDto.getBpwd());
            int count = ps.executeUpdate();
            if(count == 1 ) {return true;}

        } catch (Exception e){
            e.getMessage();
        }
        return false;
    }

    // 2. 게시물 전체 조회
    public ArrayList<BoardDto> findAll(){
        ArrayList<BoardDto> list = new ArrayList<>();
        try{
            String sql = "select * from board"; // 1. sql 작성한다.
            PreparedStatement ps = conn.prepareStatement( sql ); // 2. sql 기재한다.
            // 3. sql 실행하고 결과를 조작하는 ResultSet 인터페이스로 받는다.
            ResultSet rs = ps.executeQuery();
            // 4. 조회 결과의 레코드 하나씩 조회하기 .next() : 다음레코드 이동
            while ( rs.next() ){
                // 5. 현재 조회된 레코드를 DTO로 만들기
                BoardDto boardDto = new BoardDto(
                        // * 현재 조회중인 레코드의 특정 필드명의 값 반환.  rs.get타입("필드명")
                        rs.getInt("bno") , rs.getString("btitle"),
                        rs.getString("bcontent"), rs.getString("bdate"),
                        rs.getString("bwriter") , null // 패스워드는 보안상 조회시 제외
                );
                list.add( boardDto );  // 6. 만든 DTO에 ArrayList에 대입.
            } // w end
        } catch (Exception e) {  System.out.println(e); }
        return list; // 7. 리스트 반환
    }
    // 3. 게시물 개별 조회
    public BoardDto findId(int bno){
        try {
            //1. SQL작성
            String sql = "select * from board where bno = ?";

            //2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. sQl 조작, 실행
            ps.setInt(1, bno);
            ResultSet rs = ps.executeQuery();

            //4.SQL 결과
//            while (rs.next()) {
//                int getBno = rs.getInt("bno");
//                String getBtitle = rs.getString("btitle");
//                String getBcontent = rs.getString("bcontent");
//                String getBdate = rs.getString("bdate");
//                String getBwriter = rs.getString("bwriter");
//                String getBpwd = null;
//
//                boardDto = new BoardDto(getBno, getBtitle, getBcontent, getBdate, getBwriter, getBpwd);
//
//            } //while end
            if(rs.next()){
                BoardDto boardDto = new BoardDto(
                        rs.getInt("bno") , rs.getString("btitle"),
                        rs.getString("bcontent"), rs.getString("bdate"),
                        rs.getString("bwriter") , null // 패스워드는 보안상 조회시 제외
                );
                return boardDto;
            }


        }catch (Exception e) {
            System.out.println(e);
        }// try-catcn end
        return null;
    }// findId end

    // 4. 게시물 수정
//    public boolean update(int bno, BoardDto updateBoardDto){
//        try{
//            //1. SQL 작성
//            String sql = "update board set btitle = ?, bcontent = ?, bdate = current_timestamp where bno = ?";
//
//            //2. SQL 기재
//            PreparedStatement ps = conn.prepareStatement(sql);
//
//            //3. SQL 조작
//            ps.setString(1, updateBoardDto.getBtitle());
//            ps.setString(2, updateBoardDto.getBcontent());
//
//
//            //4. SQL실행결과
//            int result = ps.executeUpdate();
//
//            if(result == 1){
//                return true;
//            }// if end
//        }catch (Exception e){
//            System.out.println(e);
//        }// try-catch end
//        return false;
//    }// update end

    // 수업코드
    public boolean update(BoardDto updateBoardDto){
        try{
            //1. SQL 작성
            String sql = "update board set btitle = ?, bcontent = ? where bno = ?";

            //2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. SQL 조작
            ps.setString(1, updateBoardDto.getBtitle());
            ps.setString(2, updateBoardDto.getBcontent());
            ps.setInt(3, updateBoardDto.getBno());

            //4. SQL실행결과
            int result = ps.executeUpdate();

            if(result == 1){
                return true;
            }// if end
        }catch (Exception e){
            System.out.println(e);
        }// try-catch end
        return false;
    }// update end

    // 5. 게시물 삭제
    public boolean delete(int deleteBno){
        try{
            //1. SQL 작성
            String sql = "delete from board where bno = ?";

            //2. SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            //3. SQL 조작, 실행
            ps.setInt(1, deleteBno);
            int result = ps.executeUpdate();

            if(result == 1){
                return true;
            }// if end
        }catch (Exception e){
            System.out.println(e);
        }// try-catch end
        return false;
    }// delete end
}
