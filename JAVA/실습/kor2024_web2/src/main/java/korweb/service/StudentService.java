package korweb.service;

import korweb.model.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired StudentMapper studentMapper;

    // 1. 학생 점수 등록
    public int save (Map<String, Object> map) {
        System.out.println("StudentService.save");
        // 1. insert하기 전 map 매개변후
        System.out.println("map = " + map); // sno가없다
        // * insert 실행
        int result = studentMapper.save(map);
        // 2. insert 실행 후 map 매개변수
        // Save 처리 이후 자동으로 생성된 pk값을 반환받는다.
        System.out.println("map = " + map); //sno가 생겼다
        return  result;
    }

    // 2. 학생 조회
    public List< Map<String, Object> > findAll() {
        System.out.println("StudentController.findAll");
        System.out.println();
        return studentMapper.findAll();
    }

    // 3. 특정한 점수 이상의 학생 조회
    public List<Map<String, Object>> findStudentScores ( int minKor, int minMath){
        return studentMapper.findStudentScores(minKor, minMath);
    }

    // 4. 여러명의 학생을 한 번에 등록하기
    public boolean saveAll(List<Map<String, Object>> list){
        return studentMapper.saveAll(list);
    }

}
