package wait.model.dao;

import org.springframework.stereotype.Component;
import wait.model.dto.WaitListDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Component
public class WaitListDao {

    //DB연동
    private Connection conn;

    WaitListDao() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb0110", "root", "auddnjs20");
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    //대기명단 제일 끝번호 조회
    public int getLastNum(){
        int lastNum = 0;
        try{
            // 이전 대기명단엘 제일 마지막 번호 찾는 sql문
            String sql = "select max(wait_num) as last_num from waitlist";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //last_num에 sql문으로 select한 값을 대입하기
            if(rs.next()){
               lastNum = rs.getInt("last_num");
            }
        }catch (Exception e){
           e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return lastNum + 1;
    }

    //1. 대기명단 등록
    public int regist(WaitListDto waitListDto){
        try{
            int newWaitNum = getLastNum();

            String sql = "insert into waitlist(gphone, gpersonel, wait_num) values(?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitListDto.getGphone());
            ps.setInt(2, waitListDto.getGpersonel());
            ps.setInt(3, newWaitNum);

            int count = ps.executeUpdate();
            if(count == 1) {
                return newWaitNum;
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return -1;
    }

    //2. 대기명단 목록
    public ArrayList<WaitListDto> list(){
        ArrayList<WaitListDto> list = new ArrayList<>();
        try{
            String sql = "select * from waitlist";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                WaitListDto waitListDto = new WaitListDto(
                        rs.getInt("gno"), rs.getString("gphone"),
                        rs.getInt("gpersonel"), rs.getInt("wait_num")
                );
                list.add(waitListDto);
                System.out.println(waitListDto);
            }
        } catch (Exception e){
            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
        return  list;
    }


}
