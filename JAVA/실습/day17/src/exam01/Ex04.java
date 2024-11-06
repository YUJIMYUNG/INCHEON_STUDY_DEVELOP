package exam01;

public class Ex04 {
    public static void main(String[] args) {
        String trans = "TAXI";
        //Transportation taxi = Enum.valueOf(Transportation.class, trans);
        Transportation taxi = Transportation.valueOf(trans);
        System.out.println(taxi);
    }
}
