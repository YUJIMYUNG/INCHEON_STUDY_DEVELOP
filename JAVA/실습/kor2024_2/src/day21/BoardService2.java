package day21;

//BoardService1
//내용과 작성자로 구성된 게시물 최대 100개 까지 저장하는 서비스 구축
//조건 : main함수 1개, 배열 최대 2개까지, 반복문 사용
//구축 : 게시물 쓰기와 게시물 출력 기능 구현

import java.util.Scanner;

public class BoardService2 {
    public static void main(String[] args) {

        // BoardService1 에서 변수를 사용 했는데 배열변수를 사용하는 이유
        // - 여러개의 변수에 있는 데이터를 배열로 사용하려면 관리가 편하다.

        // 배열이란 ? 여러개의 동일한 타입의 데이터들을 하나의 변수에 저장할 수 있는 타입 (참조타입)
        // - 음료냉장고[배열], - 사이다음료, 콜라음료,
        // 인덱스란 ? 배열내 저장된 데이터들의 저장 순서 번호. 0번~ 최대길이까지
        // 반복문 활용 : 시작부터 끝 값까지 반복
        String[] writers = new String[100]; // 배열선언 방법 : 타입[] 변수명 = new 타입[갯수];
        String[] contents = new String[100]; // String 데이터 100개를 저장할 수 있는 배열 선언

        Scanner scan = new Scanner(System.in);

        while (true) { // 무한루프
            System.out.println("1. 게시물 쓰기 2. 게시물 출력 선택 : ");
            int choose = scan.nextInt(); // 게시물 쓰기 or 출력 입력
            if (choose == 1) {
                System.out.println("새로운 게시물 제목 : ");
                String cont = scan.next();

                System.out.println("새로운 게시물 작성자 : ");
                String writ = scan.next();

                // 만약에 게시물이 비어있으면, 게시물 100개이면 if문 100개 쓰는것이 아니라 반복문 활용
                // 인덱스 0 부터 마지막인덱스 99 까지 1씩 증가
                // 스위치 변수 = 상태 저장하는 변수
                boolean save = false;  // 처음에는 false 해서 저장 실패 했다는 뜻

                for (int i = 0; i < contents.length; i++) {
                    if (contents[i] == null) { // 만약에 index 번째 게시물에 내용이 없으면
                        contents[i] = cont; // 비어있는 게시물에 내용 저장
                        writers[i] = writ; // 비어있는 게시물에 작성자 저장
                        save = true; // 만약에 저장 성공 했으면 save 변수에 true 값으로 변경
                        break; // 만약에 저장을 했으면 1개 저장해야 하므로 break 해서 반복문 종료
                    }

                }
                // for 종료 후에 save 변수값이 false이면 출력
                if (!save) {
                    System.out.println("게시물 쓰기 성공.");
                } else {
                    System.out.println("게시물 쓰기 실패 : 빈 공간이 없습니다.");
                }
            }
            if (choose == 2) {
                for (int i = 0; i < contents.length; i++) {
                    if (contents[i] != null) { //만약에 index번째 게시물이 존재하면
                        System.out.printf("작성자 : %s, 내용 : %s%n", writers[i], contents[i]);
                    }
                }
            }

        }

    }
}
