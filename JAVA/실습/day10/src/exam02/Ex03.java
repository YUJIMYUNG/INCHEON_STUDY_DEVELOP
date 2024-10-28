package exam02;

public class Ex03 {
    public static void main(String[] args) {
//        Animal[] animals = new Animal[3];
//        animals[0] = new Bird();
//        animals[1] = new Tiger();
//        animals[2] = new Human();

        // 배열 선언 동시에 초기화
        Animal[] animals = {
                new Bird(),
                new Human(),
                new Tiger()
        };

        for(Animal animal : animals) {
            animal.move();
        }

    }
}
