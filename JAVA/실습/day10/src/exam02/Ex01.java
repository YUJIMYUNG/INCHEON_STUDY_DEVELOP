package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Animal bird = new Bird(); // Bird에 Animal이 포함되어 있다! - 다형성
        bird.move();

        Animal tiger = new Tiger();
        tiger.move();

        Animal human = new Human();
        human.move();


    }
}
