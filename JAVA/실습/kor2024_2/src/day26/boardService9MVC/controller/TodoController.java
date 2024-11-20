package day26.boardService9MVC.controller;

import day26.boardService9MVC.model.TodoDao;
import day26.boardService9MVC.model.TodoDto;

import javax.management.loading.PrivateClassLoader;
import java.util.ArrayList;

public class TodoController {
    // 싱글톤
    private static TodoController todoController = new TodoController();
    private TodoController(){}
    public static TodoController getInstance(){
        return todoController;
    }

    public boolean todoWrte(String todoContent, int date, boolean state){
        TodoDto todoDto = new TodoDto(todoContent, date, state);
        return TodoDao.getInstance().todoWrite(todoDto);
    }

    public ArrayList<TodoDto> todoPrint(){
        ArrayList<TodoDto> result = TodoDao.getInstance().todoPrint();
        return result;
    }
}
