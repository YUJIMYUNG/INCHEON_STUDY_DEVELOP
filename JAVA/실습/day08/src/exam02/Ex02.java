package exam02;

public class Ex02 {
    public static void main(String[] args) {
        Schedule2 s1 = new Schedule2();
        s1.setYear(2024); // year, month, day 변수는 정보 은닉 상태
        s1.setMonth(12);
        s1.setDay(10);
        s1.showDate();
    }
}
