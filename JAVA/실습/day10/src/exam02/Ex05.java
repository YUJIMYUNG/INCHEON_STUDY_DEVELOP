package exam02;

public class Ex05 {
    public static void main(String[] args) {
        Animal[] animals = {new Bird(), new Tiger(), new Human()};

        for(Animal animal : animals){
            animal.move();
            if(animal instanceof Human){
                Human human = (Human)animal; // 다운캐스팅
                human.reading();
            } else if (animal instanceof Bird) {
                Bird bird = (Bird)animal; // 다운캐스팅
                bird.singing();
            } else if (animal instanceof Tiger tiger) { // 다운캐스팅 JDK17버전 이후 사용
                tiger.hunting();
            }

        }

    }
}
