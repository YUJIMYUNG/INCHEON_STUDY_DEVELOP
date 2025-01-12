package wait.model.dao;

import org.springframework.stereotype.Component;
import wait.model.dto.WaitListDto;
import wait.model.response.WaitListResponse;

import javax.xml.transform.Result;
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
            }// if end
        }catch (Exception e){
           e.printStackTrace();
            System.out.println(e.getMessage());
        }// try-catch end
        return lastNum + 1;
    }//getLastNum end

    // 대기 시간 생성 메서드
    public int getWaitTime(){
        int lastWaitTime = 0;
        try{
            //이전 대기명단에서 제일 대기시간이 긴(wait_time) 값 찾는 sql문
            String sql = "select max(wait_time) as last_time from waitlist";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                lastWaitTime = rs.getInt("last_time");
            }// if end
        } catch (Exception e){
            System.out.println(e.getMessage());
        }// try-catch end
        // 마지막 대기시간애서 + 5분 추가
        return lastWaitTime + 5;
    }// getWaitTime end

    //1. 대기명단 등록
    public int regist(WaitListDto waitListDto){
        try{
            int newWaitNum = getLastNum();
            int newWaitTime = getWaitTime();

            String sql = "insert into waitlist(gphone, gpersonel, wait_num, wait_time) values(?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, waitListDto.getGphone());
            ps.setInt(2, waitListDto.getGpersonel());
            ps.setInt(3, newWaitNum);
            ps.setInt(4, newWaitTime);

            int count = ps.executeUpdate();
            if(count == 1) {
                return newWaitNum;
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }// try-catch end
        return -1;
    }// regist end

    // 대기명단에서 현재 대기중 팀 수를 계산하는 메서드
    public int getWaitCount (){
        int waitCount = 0;
        try{
            String sql = "select * from waitlist where wait_state = 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                waitCount++;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }// try-catch end
        return waitCount;
    }// getWaitCount end


    //2. 대기명단 목록(현재 대기중인 팀 수도 출력)
    public WaitListResponse list(){
        ArrayList<WaitListDto> list = new ArrayList<>();
        int waitCount = getWaitCount();//
        try{
            String sql = "select * from waitlist";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                WaitListDto waitListDto = new WaitListDto(
                        rs.getInt("gno"), rs.getString("gphone"),
                        rs.getInt("gpersonel"), rs.getInt("wait_num"),
                        rs.getInt("wait_time"), rs.getBoolean("wait_state")
                );
                list.add(waitListDto);
            }// while end
        } catch (Exception e){
            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }// try-catch end
        return new WaitListResponse(list, waitCount);
    }// list end


    //3. 대기명단에서 삭제 하면서 대기시간 update
    public boolean delete(int deleteGno){
        try{
            int deletedWaitNum = 0;
            // 삭제 할 대기자의 번호 조회해서 deletedWaitGno변수에 저장
            String selectSql = "select wait_num from waitlist where gno = ?";
            PreparedStatement selectPs = conn.prepareStatement(selectSql);
            selectPs.setInt(1, deleteGno);
            ResultSet rs = selectPs.executeQuery();
            if (rs.next()) {
                deletedWaitNum = rs.getInt("wait_num");
            }// if end

            // 대기 명단 삭제
            String delSql = "delete from waitlist where gno = ?";
            PreparedStatement delPs = conn.prepareStatement(delSql);
            delPs.setInt(1, deleteGno);
            int result = delPs.executeUpdate();

            // 삭제되면 대기시간 업데이트
            if(result == 1){
                // 대기번호가 삭제한 대기자의 번호(deleteWaitGno)
                String updateSql = "update waitlist set wait_time = wait_time -5 where wait_state = 1 and wait_num > ?";
                PreparedStatement updatePs = conn.prepareStatement(updateSql);
                updatePs.setInt(1, deletedWaitNum);
                updatePs.executeUpdate();

                return true;
            }// if end
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }// try-catch end
        return false;
    }// delete end

    public ArrayList<WaitListDto> mypage(String gphone){
        ArrayList<WaitListDto> list = new ArrayList<>();

        try{
            // 조회된 전화번호 
            String sql = "select * from waitlist where gphone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, gphone);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                WaitListDto waitListDto = new WaitListDto(
                        rs.getString("gphone"), rs.getInt("gpersonel"),
                        rs.getInt("wait_num"), rs.getInt("wait_time")
                );
                list.add(waitListDto);
                System.out.println("mypage 데이터 확인" + waitListDto);
            } // while end

            // 조회된 전화번호에 대한 정보가 없는지 확인
        }catch (Exception e){
            System.out.println(e.getMessage());
        } // try- catch end
        return list;
    }


}
