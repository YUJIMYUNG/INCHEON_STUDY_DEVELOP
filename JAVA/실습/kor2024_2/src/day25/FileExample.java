package day25;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileExample {
    public static void main(String[] args) {
        // 1.파일 출력(쓰기)
        // - 자바에서 사용되는 데이터를 자바외부(c:/java)에 메모장으로 저장
        try {//예외가 발생 할 것 같은 코드 try{}안에서 작성한다.

            //FileOutputStream fileOut = new FileOutputStream("/Users/jimyung/INCHEON_STUDY_DEVELOP/JAVA/실습/kor2024_2/test1.txt");

            //- 현재 프로젝트 내 'src-day25-test1.txt'파일 생성
            FileOutputStream fileOut = new FileOutputStream("./src/day25/test1.txt");
            fileOut.write("Hello Java".getBytes());
        } catch (FileNotFoundException e){
            // 특정 예외가 발생했을 때 실행되는 코드를 작성
            e.printStackTrace();
        } catch (Exception e) {
            // 모든 예외가 발생했을 때 실행되는 코드 작성
            // Exception : 모든 예외클래스의 최상위 클래스
            e.printStackTrace();
        } finally {
            // 예외가 있던 없던 실행되는 코드를 작성한다.

        }



    }
}
