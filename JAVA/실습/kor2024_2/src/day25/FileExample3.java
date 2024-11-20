package day25;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

public class FileExample3 {
    public static void main(String[] args) {
        try{
            // 생각해보기  :
            // 1. 키보드로부터 입력받은 문자열 day25폴더 내 'test2.txt'에 저장하시오
            // - 1. 입력 객체
            Scanner scan = new Scanner(System.in);

            // - 2. 키보드로 입력받기
            System.out.print("파일에 저장할 내용 : ");
            String outStr = scan.next();

            // - 3. 파일 출력 객체 생성, 파일의 경로 지정
            FileOutputStream fileOutput= new FileOutputStream("./src/day25/test2.txt");
            // - 4. 파일 출력 객체를 이용한 문자열 출력하기
            fileOutput.write(outStr.getBytes());
            System.out.println("[저장 성공]");


            // 2. 'day25'폴더 내 Test2.txt 에 저장된(문자열)바이트를 읽어 콘솔에 저장하시오.
            // - 1. 파일 입력 객체 생성, 위에서 생성된 메모장을 읽어오기
            FileInputStream fileInput =  new FileInputStream("./src/day25/test2.txt");

            // - 2. 읽어온 바이트를 저장할 바이트 배열 선언
            // 현재 읽어올 파일의 용량을 몰라서 임의로 1000개로 한다.
            // byte[] bytes = new byte[1000]; // 1000개의 바이트(영문 한글자당 1바이트, 한글 한 글자당 2바이트)를 저장할 수 있는 배열 선언

            // - 2-2. 읽어올 파일을 용량/바이트 개수 확인 후 파일의 용량만큼 배열 선언
            File file = new File("./src/day25/test2.txt");
            System.out.println(file.isFile());
            System.out.println(file.getName());
            System.out.println(file.length());// 반환타입 long
            byte[] bytes = new byte[(int)file.length()] ;
            // 배열내[] 안에 들어가는 배열 크기는 타입이 int만 가능하다.

            // - 3. 준비된 바이트배열에 읽어온 바이트를 저장한다.
            fileInput.read(bytes);

            // - 4. 바이트를 문자열로 다시 변환 하기
            String inStr = new String(bytes);
            System.out.println("[불러오기 성공]");
            System.out.println(inStr);
        // !: 만약에 파일 객체가 지정한 경로에 파일이 존재하지 않으면 예외 발생
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }






    }
}
