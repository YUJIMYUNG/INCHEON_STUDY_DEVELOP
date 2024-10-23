package exam01;

// 힙 영역 메모리 - 객체 전용 메모리
public class Student {
        // 변수에 대한 정의
        int id ; // 학번
        String name; // 학생명
        String major; // 전공과목

        void study() { // 기능 정의 - study(공부) 라는 기능의 함수
            System.out.printf("%s(%d)이 %s를 전공한다.%n", name, id, major);
        }

        // 함수에 대한 정의

}
