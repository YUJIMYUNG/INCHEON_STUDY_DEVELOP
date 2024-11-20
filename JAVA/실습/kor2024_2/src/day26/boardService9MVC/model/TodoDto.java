package day26.boardService9MVC.model;

public class TodoDto {

    private String todoContent; // 할일 내용
    private int date; // 마감날짜
    private boolean todoState; // 할일 상태
    TodoDto() {

    }

    // 생성자
    public TodoDto(String todoContent, int date, boolean todoState) {
        this.todoContent = todoContent;
        this.date = date;
        this.todoState = todoState;
    }

    public String getTodoContent() {
        return todoContent;
    }

    public void setTodoContent(String todoContent) {
        this.todoContent = todoContent;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public boolean isTodoState() {
        return todoState;
    }

    public void setTodoState(boolean todoState) {
        this.todoState = todoState;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "todoContent='" + todoContent + '\'' +
                ", date=" + date +
                ", todoState=" + todoState +
                '}';
    }
}
