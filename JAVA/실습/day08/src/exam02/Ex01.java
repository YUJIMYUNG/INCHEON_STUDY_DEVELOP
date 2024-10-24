package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Schedule s1 = new Schedule();
//        통제 불가
//        s1.year = 2024;
//        s1.month = 10;
//        s1.day = 24;

        s1.setYear(2024); // setter 메서드
        s1.setMonth(2);
        s1.setDay(31);

        int month = s1.getMonth();
        System.out.println(month); // gette 메서드로 조회

        s1.showDate();
    }
}
