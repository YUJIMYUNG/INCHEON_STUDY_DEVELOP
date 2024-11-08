package exam02;

import java.util.HashSet;

public class Ex02 {
    public static void main(String[] args) {
        HashSet<Book> books = new HashSet<>();
        for(int i = 1; i <= 10; i++){
            books.add(new Book("책" + i, "저자" + i, "출판사" + i));
        }

        books.add(new Book("책2", "저자2", "출판사2")); // 중복 데이터 만들기

        for(Book book : books){
            System.out.println(book);
        }


    }
}
