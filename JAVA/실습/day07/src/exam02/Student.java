package exam02;

public class Student {
    int id; // 학번
    String name; // 이름
    String major; // 전공과목

    public Student() { // 기본 생성자
        // 기본 생성자는 반환값을 접근 못하게 통제한다.
        // 실제 반환값은 주소값이다.
        // return 예약어도 쓸 수 없다!

        // 객체 생성 완료 이후 실행되는 코드
        // 객체 생성 완료 -> 변수 정의 -> 인스턴스 변수 생성 완료 상태
        // 인스턴스 변수 초기화 작업을 주로 진행
        id = 1000;
        name = "이이름";
        major = "수학";
    }

    public Student(int _id, String _name, String _major) {
        id = _id;
        name = _name;
        major = _major;

    }

    // 함수 정의
    void showInfo() {
        System.out.printf("id=%d, name=%s, major=%s%n", id, name, major);
    }
}
