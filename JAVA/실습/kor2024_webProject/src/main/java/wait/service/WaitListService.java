package wait.service;

import wait.model.dao.WaitListDao;
import wait.model.dto.WaitListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WaitListService {
    @Autowired private WaitListDao waitListDao;

    //1. 대기명단 등록
    public boolean regist(WaitListDto waitListDto){
        boolean result = waitListDao.regist(waitListDto);

        return result;
    }

    //2. 대기명단 목록
    public ArrayList<WaitListDto> list() {
        ArrayList<WaitListDto> result = waitListDao.list();

        return result;
    }
}
