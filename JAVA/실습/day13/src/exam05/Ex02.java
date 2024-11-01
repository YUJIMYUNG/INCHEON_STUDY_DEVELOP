package exam05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex02 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("a.txt");
            // throw new FileNotFountException();

            System.out.println("문제 없음");
        } catch (FileNotFoundException e) {
            System.out.println("예외 발생!");
        }
    }
}
