package day30.boardService10MVC;

import day30.boardService10MVC.view.BoardView;

public class AppStart {
    public static void main(String[] args) {
        // 메인 뷰 요청
        // - 다른 클래스의 존재하는 함수를 호출하는 방법
        // -- 1. 객체를 생성한 후 객체명, 메소드명() 호출
        // -- 단 패키지가 다르면 메서드룰 public 함수로 선언한다.

        /* 싱글톤 사용하기 전
        BoardView view = new BoardView();
        view.mainPage();

         */

        // 싱글톤 사용했을 때
        BoardView.getInstance().mainPage();
            // BoardView.getInstance() ==> boardView
            // boardView.mainPage();
    }
}
