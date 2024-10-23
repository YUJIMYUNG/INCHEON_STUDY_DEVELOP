package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(); // new -> 메모리 생성, 공간을 만들어주는 연산자
        s1.id = 1000; // 인스턴스 변수(생성된 객체) (id)
        s1.name = "이이름"; // 인스턴스 변수 (name)
        s1.major = "수학"; // 인스턴스 변수 (major)

        s1.showInfo();

        System.out.println(System.identityHashCode(s1)); // s1의 주소값

        Student s2 = new Student();
        s2.id = 1001;
        s2.name = "김이름";
        s2.major = "영어";
        // 참조 자료형은 주소값만 갖고있다!


        s2.showInfo();
        System.out.println(System.identityHashCode(s2));

        Student s3 = s2; // s2는 주소값 -> 그 주소값을 s3에 대입
        s3.name = "최이름";
        s3.showInfo();
        s2.showInfo();
    }
}
