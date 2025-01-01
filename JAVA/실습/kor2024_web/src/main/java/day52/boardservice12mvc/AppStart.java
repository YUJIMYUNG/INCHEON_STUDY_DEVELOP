package day52.boardservice12mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        // 콘솔 뷰가 아닌 싱글톤 내부 함수 호출
        //BoardView.getInstance().run();

        SpringApplication.run(AppStart.class);
    }
}
