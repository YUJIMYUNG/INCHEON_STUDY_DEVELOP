package exam01;

public class Ex01 {
    public static void main(String[] args) {
        Transportation transportation = Transportation.BUS;
        System.out.println(transportation instanceof Transportation);

        Enum<Transportation> e = transportation;
    }
}
