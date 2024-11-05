package exam04;

public class Ex03 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.setItem(new Apple());

        System.out.println(appleBox); // appleBox.toString();
    }
}
