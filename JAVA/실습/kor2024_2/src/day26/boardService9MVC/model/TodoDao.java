package day26.boardService9MVC.model;

import day23.boardService8MVC.model.BoardDto;

import java.io.*;
import java.util.ArrayList;

/*
    TODOLIST 구축하기

    조건 1 : BoardService9mvc 활용하여 mvc패턴과 싱글톤패턴과 파일처리 기능을 사용하시오
    조건 2 : 할일 관리 기능은 할일 등록과 할일 전체출력 기능을 구현하시오
    조건 3 : 할일 객체의 필드는 할일 내용, 할일 마감날짜, 할일 상태 3개 필드는 필수, 추가가능

    -활용조건 1: 할일 삭제 기능을 구현하시오
    -활용조건 2: 할일 상태 수정 기능을 구현하시오. 완료-> 미완료, 미완료-완료


 */

public class TodoDao {

    // 싱글톤
    private static TodoDao todoDao = new TodoDao();
    private TodoDao(){
        File file = new File("./src/day26/boardService9mvc/todo.txt");
        // 파일이 존재 하는지 확인
        if( file.exists() ){
            todoLoad();
        }else{
            try {
                file.createNewFile();
            }catch ( IOException e ){
                e.printStackTrace();
            }
        } // if-else end
    }

    public static TodoDao getInstance(){
        return todoDao;
    }

    // todoList 저장해주는 객체
    ArrayList<TodoDto> todoDB = new ArrayList<>();

    // 1. 할일 등록 접근 합수
    public boolean todoWrite(TodoDto todoDto){
        todoDB.add(todoDto);
        todoListSave();
        return true;
    }

    // 2. 할일 전체 출력 함수
    public ArrayList<TodoDto> todoPrint() {
        return todoDB;
    }


    //--------------------------영구 저장을 위한 내용들을 할 일 파일에 저장하는 기능-------------------------------
    //1. 할 일 등록을 성공했을 때 지정한 함수 사용 및 호출
    public void todoListSave() {
        // 문자열 변수 선언
        String outStr = "";
        // 반복문을 이용하여 csv형태로 할 일 내용, 할일 날짜, 할 일의 상태를 대입 시킨다.
        for(int i = 0; i <= todoDB.size() -1 ; i++){
            TodoDto todoDto = todoDB.get(i);
            outStr += todoDto.getTodoContent() + "," + todoDto.getDate() + "," + todoDto.isTodoState();
            outStr += "\n";
        } // for end
        // 확인용
        System.out.println(outStr);

        try {
            // 파일 출력 객체 생성
            FileOutputStream outputStream = new FileOutputStream("./src/day26/boardService9mvc/todo.txt");
            // 파일 출력 객체를 이용한 바이트 쓰기/내보내기
            outputStream.write(outStr.getBytes());

            System.out.println("[할 일 저장 성공]");
        } catch( FileNotFoundException e) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        } // try-catch end
    } // todoListSave end

    // -------------------------------영구 저장 된 파일의 할 일 들을 가져오는 기능 ------------------------
    public void todoLoad(){
        try{
            //1. 파일 입력 객체 생성
            FileInputStream inputStream = new FileInputStream("./src/day26/boardService9mvc/todo.txt");

            // 2. 파일 용량만큼 바이트 배열 선언
            File file = new File("./src/day26/boardService9mvc/todo.txt");
            byte[] bytes = new byte[(int)file.length()];

            // 3. 파일 입력 객체를 이용하여 파일을 읽어서 바이트배열에 저장
            inputStream.read(bytes);

            // 4. 읽어온 바이트 배열을 문자열로 반변환
            String inStr = new String(bytes);

            // 5-1\n기준으로 분해 후 배열로 반환
            String[] objStr = inStr.split("\n");
            // 5-2 객체네 필드 구분문자
            for(int i = 0; i <= objStr.length -1 ; i++) {
                // 5-3 한개의 객체 필드 값들 가져오기
                String obj = objStr[i];
                String[] field = obj.split(",");
                String todoContent = field[0];
                int date = Integer.parseInt(field[1]);
                boolean state = Boolean.parseBoolean(field[2]);
                TodoDto todoDto = new TodoDto(todoContent, date, state);
            }// for end

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } // try-catch end
    } // todoLoad end



}
