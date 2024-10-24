package exam02;

public class Schedule {
    private int year; // 년
    private int month; // 월
    private int day; // 일

    // 생성된 객체를 메서드를 통해 값에 접근
    public void setYear(int _year){
        year = _year;
    }
    public int getYear(){
        return year;
    }

    public void setMonth(int _month) {
        month = _month;
    }
    public int getMonth(){
        return month;
    }

    public void setDay(int _day){
        if(month == 2 && _day > 28) { // 값을 통제할 수 있다.
            _day = 28;
        }

    }
    public int getDay(){
        return day;
    }

    void showDate(){
        System.out.printf("year=%d, month=%d, day=%d%n", year, month, day);
    }
}
