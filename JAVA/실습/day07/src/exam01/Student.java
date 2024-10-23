package exam01;

public class Student {
    int id; // 학번
    String name; // 학생명
    String major; // 전공과목

    public Student() {}  // 기본 생성자 - 컴파일러가 자동 추가(생성자 함수가 정의 되지 않은 경우)

    void showInfo() {
        System.out.printf("id=%d, name=%s, major=%s%n",id, name, major);
    }

}
