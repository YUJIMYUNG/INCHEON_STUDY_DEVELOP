package day52.boardservice8mvc.view;

import day52.boardservice8mvc.controller.BoardController;
import day52.boardservice8mvc.model.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardView {
    private BoardView(){};
    private static BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }

    private Scanner scan = new Scanner(System.in);

    public void run(){
        while(true){
            System.out.println("1. 등록 2. 출력 : ");
            int choose = scan.nextInt();
            if(choose == 1) {
                write();
            } else if (choose == 2){
                findAll();
            } // if-else if end
        } // while end
    } // run end

    public void write(){
        System.out.println("게시물 쓰기 페이지");

        scan.nextLine();
        System.out.print("title :");
        String title = scan.nextLine();

        System.out.print("content : ");
        String content = scan.nextLine();

        System.out.print("password : ");
        int pwd = scan.nextInt();
        BoardDto boardDto = new BoardDto(title, content, pwd);

        boolean result = BoardController.getInstance().write(boardDto);
        if(result){
            System.out.println("write success");
        } else {
            System.out.println("write fail");
        }

    }

    public void findAll(){
        System.out.println("게시물 출력 페이지");
        ArrayList<BoardDto> result = BoardController.getInstance().findAll();
        for(int i = 0;  i < result.size() ; i++ ) {
            System.out.print("제목 : " + result.get(i));
            System.out.print("내용 : " + result.get(i));
            System.out.print("비번 : " + result.get(i));
        }
    }
}
