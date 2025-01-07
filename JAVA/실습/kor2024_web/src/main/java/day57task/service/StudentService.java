package day57task.service;

import day57task.model.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    // spring이 만든 빈(객체.인스턴스)을 줘
    @Autowired private StudentDao studentDao;
}
