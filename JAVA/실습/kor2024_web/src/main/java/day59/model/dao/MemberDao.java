package day59.model.dao;

import day59.model.dto.MemberDto;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Component
public class MemberDao {
    private Connection conn;
    MemberDao() {
        try {
            // DB연동
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0109", "root", "auddnjs20");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    // 회원가입
    public boolean signup(MemberDto memberDto){
        try{
            String sql = "insert into member(mid, mpwd, mname, mphon) value(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMid());
            ps.setString(2, memberDto.getMpwd());
            ps.setString(3, memberDto.getMname());
            ps.setString(4, memberDto.getMphon());

            int count = ps.executeUpdate();
            if(count == 1) {return true;}
        } catch (Exception e){
            e.getMessage();
        }
        return true;
    }

    // 로그인
    public boolean login(String mid, String mpwd){
        try {
            String sql = "select * from board where mid = ?, mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mid);
            ps.setString(2, mpwd);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return true;
            }
            return false;

        } catch (Exception e){
            e.getMessage();
        }
        return true;
    }
}
