package exam01;

    public class Ex01 {
        public static void main(String[] args) {
            // Student <-(Class) 참조 자료형 을 s1이라는 이름의 new Student(); 객체로 생성
            // s1 : 참조변수
            Student s1 = new Student();
            //s1 이라는 주소를 찾아서 id라는 변수에 값을 대입
            s1.id = 1000; // 변수 정의 -> 변수
            s1.name = "김이름";
            s1.major = "자바";

            s1.study();

            System.out.println(System.identityHashCode(s1)); // s1의 주소값을 볼 수 있는 메서드
        }
}
