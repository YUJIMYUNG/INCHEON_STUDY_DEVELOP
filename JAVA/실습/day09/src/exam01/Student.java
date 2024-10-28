package exam01;

public class Student {
    static int id ; // 로드시 이미 변수로 공간 할당
    String name;
    String major;

    public Student(int id, String name, String major){
        Student.id = id;
        this.major = major;
        this.name = name;
    }

    public void showInfo() {
        System.out.printf("id=%d, name=%d, major=%d", id, name, major);
        staticMethod(); // 인스턴스 매서드 내에서는 호출 가능
    }

    // 정적 메서드
    public static void staticMethod(){
        System.out.println("정적 메서드!");
        //this.name = 객체의 자원은 접근 불가 (인스턴스 변수, 인스턴스 메서드 사용 불가능)
        //this.showInfo(); 불가능


    }
}