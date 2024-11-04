package exam02;

import java.util.List;

public class Ex06 {
    public static void main(String[] args) {
        List<Book> books = List.of(
                new Book("책1", "저자1", "출판사1"),
                new Book("책2", "저자2", "출판사2"),
                new Book("책2", "저자2", "출판사2"),
                new Book("책3", "저자3", "출판사3"),
                new Book("책4", "저자4", "출판사4"),
                new Book("책5", "저자5", "출판사5")
        );

        List<Book> books2 = books.stream().distinct().toList(); // distinct() : 중복제거
        for(Book book : books2){
            System.out.println(books2);
        }
    }
}
