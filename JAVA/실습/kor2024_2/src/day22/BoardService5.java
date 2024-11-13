package day22;

// BoardService5
// BoardService4 모든 코드를 복사후 진행
// 기존 코드 : 가변길이 배열 구현
// 수정 조건 : 가변길이 배열 대신 ArrayList 컬랙션 프레임으로 수정하시오

// 컬랙션(수집) 프레임워크(미리 만들어진 구조) : (데이터)수집 관련 클래스들
//      - 여러개의 데이터들을 하나의 객체에서 관리하기 위해서 : 배열을 가변길이로 구현하는 방법이 복잡하기 때문에
//      - 자바 회사에서 배열을 이용한 가변길이의 배열클래스를 이용하여 편리성과 기능을 제공한다.
//    - 대표 인터페이스 : List, Set, Map 컬렉션
//    - Arraylist 클래스
//     대표 함수
//    .add(새로운 객체) : 리스트내 지정한 객체 저장하는 함수
//    .get(인덱스) : 리스트내 지정한 인덱스에 객체 반환 함수
//    .size() : 리스트내 저장한 총 객체 수 반환 함수
//    .remove(인덱스) : 리스트내 지정한 인덱스에 객체 삭제하는 함수

import java.util.ArrayList;
import java.util.Scanner;

public class BoardService5 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 컬렉션 프레임워크 중 ArrayList클래스를 이용한 배열을 대체한다.
        //  개발자에게 편의성 제공
        //      ArrayList<제네릭타입> : 리스트 객체에 저장할 여러개 객체들의 타입
        // 배열(고정길이) vs 컬렉션 프레임워크(가변길이)
        ArrayList<Board> boardList= new ArrayList<>();

        while(true) {
            System.out.print("1.글쓰기 2. 출력");
            int choose = scan.nextInt();

            if(choose == 1){
                scan.nextLine();
                // 사용자로부터 저장할 데이터 입력을 받는다.
                System.out.print("게시물 제목");
                String content = scan.nextLine();
                // .next() 문자열(공백x) 입력, .nextLine() 문자열(공백/띄어쓰기 포함)입력
                // .nextLine() 사용시 주의할점 : .nextLine()앞에 또 다른 .nextxx가 존재하면 의미없는 .nextLine()코드를 작성하낟.
                System.out.print("게시물 작성");
                String writer = scan.next();

                System.out.print("게시물 비밀번호");
                int password = scan.nextInt();

                // 2. 입력 받은 데이터를 arrayList에 저장
                Board board = new Board();
                board.content = content;
                board.writer = writer;
                board.pwd = password;

                // 3. 컬렉션 프레임워크인 리스트객체에 게시물을 저장한다.
                boardList.add(board);

            } else if(choose == 2) {
                // 배열 내 존재하는 게시물 모두 출력하기
                for(int i = 0; i < boardList.size() ; i++){
                    System.out.printf("내용 : %s, 작성자 : %s, 비밀번호 : %d \n", boardList.get(i).content, boardList.get(i).writer, boardList.get(i).pwd);
                }
            } //  if/ else if end
        } // while end
    }
}
