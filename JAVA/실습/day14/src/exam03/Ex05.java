package exam03;

public class Ex05 {
    public static void main(String[] args) {
        try (MyResource my1 = new MyResource();
            MyResource2 my2 = new MyResource2()){

        } catch (Exception e) {}
    }
}
