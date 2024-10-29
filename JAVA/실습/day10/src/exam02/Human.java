package exam02;

public class Human extends Animal{
//    public  void move(){
//        System.out.println("두 발로 직립 보행!");
//    }

    @Override
    public void move() {
        System.out.println("두 발로 직립 보행! ");
    }

    public void reading() {
        System.out.println("독서를 한다!");
    }
}
