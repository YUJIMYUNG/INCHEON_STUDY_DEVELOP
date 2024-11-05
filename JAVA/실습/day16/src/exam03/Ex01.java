package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Box appleBox = new Box();
        appleBox.setItem(new Apple());

        // 타입 안정성이 확보가 안됨
        Object obj = (Apple)appleBox.getItem(); // 형변환 번거로움
        if(obj instanceof Apple apple){
            System.out.println(apple.info());
        }
    }
}
