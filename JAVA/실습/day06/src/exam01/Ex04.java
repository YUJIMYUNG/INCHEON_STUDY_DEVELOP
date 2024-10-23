package exam01;

public class Ex04 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 1000;
        s1.name = "김이름";
        s1.major = "수학";

        s1.study();;

        Student s2 = new Student();
        s2.id = 1001;
        s2.name = "이이름";
        s2.major = "영어";

        s1.study();
        s2.study();

        System.out.printf("s1의 주소 : %d%n", System.identityHashCode(s1) ); //s1과
        System.out.printf("s2의 주소 : %d%n", System.identityHashCode(s2) ); //s2의 주소가 다르다.


    }
}
