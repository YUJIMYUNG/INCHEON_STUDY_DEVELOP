package exam02;

import java.util.Objects;

public class Book extends java.lang.Object{
    private String title; // 책 제목
    private String author; //  책 저자
    private String publisher; // 출판사

    public Book(String title, String author, String publisher){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    //toString 재정의
//    @Override
//    public String toString() {
//        return String.format("title=%s, author=%s, publisher=%s%n", title, author, publisher);
//    }


    //generate -> toString() 으로 자동완성 가능
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }


    // 인텔리제이에서 제공해주는 자동완성
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher);
    }

    //    @Override
//    public boolean equals(Object obj) { // 동등성 비교
//        if(obj instanceof Book book){
//            if(title.equals(book.title) && author.equals(book.author) && publisher.equals(publisher)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(title, author, publisher);
//    }


}
