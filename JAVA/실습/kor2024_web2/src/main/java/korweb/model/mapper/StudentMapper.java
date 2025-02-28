package korweb.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper // mybatis와 연동하는 인터페이스임을 명시
public interface StudentMapper {


    // 1. 학생 정ㅁ수 등록
    @Insert("insert into student(name, kor, math) values(#{name}, #{kor}, #{math})")
    @Options(useGeneratedKeys = true , keyProperty = "sno") // useGeneratedKeys - autoincrement로 생성된 pk번호를 반환하겠다는 뜻
                                                            // ketProperty = 'pk명'  - pk번호를 가지는 pk필드(속성명)을 뜻한다.
    int save(Map<String, Object> map);


    // 2. 학생 전체 조회
    @Select("select * from student")
    List<Map<String,Object>> findAll();


    // 3. 특정한 점수 이상의 학생 조회(동컥 쿼리 표현)
    // 동적쿼리
    // JAVA15 이상부터 """ 문자열 """ 템플릿 지원 : 문자열 입력할떄 다음줄로 이어지는 방법
    /*
        JAVA15 미만 : String text = "안녕하세요"
                                    +"유재석입니다"; -> 더하기 연산자로 문자열 연결
        JAVA15 이상 : String text = """안녕하세요
                                      유재석입니다"""; -> 템플릿 이용한 문자열 연결, JS에서 백틱 연산자와 비슷
     */
    // sql 에서 1=1 -> 강제로 true값이 필요할 때 사용, 주로 다음 조건을 도 ㅇ적으로 처리할 때 사용한다.
    @Select("""
            <script>
            select * 
                from student
                where 1 = 1
                <if test="minKor != null">
                    and kor >= #{minKor}
                </if>
                <if test = "minMath != null">
                    and math >= #{minMath}
                </if>
            </script>
            """)
    List<Map<String, Object>> findStudentScores(int minKor, int minMath);


    // 4. 여러명의 학생을 한 번에 등록하기 (배치)
    @Insert("""
            <script>
                insert into student(name, kor, math) values 
                <foreach collection="list" item="student" separator=",">
                    (#{student.name},  #{student.kor} , #{student.math})
                </foreach>
            </script>
            """)
    boolean saveAll(List<Map<String, Object>> list);


    /*
        SQL 에서 레코드 삽입하는 방법
        1. 레코드 1개 삽입 : insert into 테이블명(필드명, 필드명) values (값1, 값2)
        2. 레코드 여러개 삽입 : insert into 테이블명(필드명, 필드명) values (값1, 값2), (값3, 값4), (값5, 값6)
     */

}
