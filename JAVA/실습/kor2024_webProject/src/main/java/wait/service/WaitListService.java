package wait.service;

import wait.model.dao.WaitListDao;
import wait.model.dto.WaitListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wait.model.response.WaitListResponse;

import java.util.ArrayList;

@Service
public class WaitListService {
    @Autowired private WaitListDao waitListDao;

    //1. 대기명단 등록
    public int regist(WaitListDto waitListDto){
        int result = waitListDao.regist(waitListDto);

        return result;
    }

    //2. 대기명단 목록
    public WaitListResponse list() {
        WaitListResponse result = waitListDao.list();

        return result;
    }

    //3. 특정 대기명단 개별 삭제
    public boolean delete(int delGno) {
        boolean result = waitListDao.delete(delGno);

        return result;
    }

    //4. 마이페이지
    public ArrayList<WaitListDto> mypage(String gphone){
        ArrayList<WaitListDto> result = waitListDao.mypage(gphone);

        return result;
    }
}
