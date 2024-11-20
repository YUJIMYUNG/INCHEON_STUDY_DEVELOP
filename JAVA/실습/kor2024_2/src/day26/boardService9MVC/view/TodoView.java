package day26.boardService9MVC.view;

import day26.boardService9MVC.controller.TodoController;
import day26.boardService9MVC.model.TodoDto;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoView {
    private static TodoView todoView = new TodoView();
    private TodoView(){

    }
    public static TodoView getInstance(){
        return todoView;
    }

    Scanner scan = new Scanner( System.in);

    public void mainPage() {
        while (true) {
            System.out.print("1.할 일 등록, 2. 할 일 출력 : ");
            int choose = scan.nextInt();
            if (choose == 1) {
                todoWrite();
            } else if (choose == 2) {
                todoPrint();
            } // if-else if end
        } // while end
    }// mainPage end

    void todoWrite(){
        scan.nextLine();
        System.out.print("할 일 내용: ");
        String todoContent = scan.nextLine();
        System.out.print("마감 날짜: ");
        int date = scan.nextInt();
        System.out.print("할 일 상태(true:완료/false:미완료): ");
        boolean state = scan.nextBoolean();

        boolean result = TodoController.getInstance().todoWrte( todoContent , date , state );

        if( result ){
            System.out.println("할 일 등록 성공");
        } else{   System.out.println("할 일 등록 실패");
        } // if-else end
    } // todoWrite end

    void todoPrint( ){

        ArrayList<TodoDto> result  = TodoController.getInstance().todoPrint();
        // 출력
        for( int index = 0 ; index<= result.size()-1 ; index++ ){
            System.out.print("할 일: " + result.get( index ).getTodoContent() );
            System.out.print("마감 날짜 : " + result.get( index ).getDate() );
            if(result.get(index).isTodoState()){ // 상태가 0이면 완료 출력
                System.out.println("상태 : 완료");
            } else {
                System.out.println("상태 : 미완료");// 상태가 1이면 미완룐 출력
            }
        } // for end
    } // m end

}// class end
