package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Book book = new Book("소년이 온다", "한강", "믿음사");
        System.out.println(book); // book.toString() : 컴파일러가 자동으로 코드를 추가!
        System.out.println(book.toString());


    }
}
