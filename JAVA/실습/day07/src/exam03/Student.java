package exam03;

public class Student {
    int id; // 학번
    String name; // 이름
    String major; // 전공과목

    void showInfo() {
        System.out.printf("id=%d, name=%s, major=%s%n", id ,name, major);
    }

    public Student () { // 기본 생성자

    }
}
