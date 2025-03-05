package example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class Animal {

}

class Dog extends Animal{

}

class Cat extends Animal{

}


public class Task1 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        List<Animal> list1 = new ArrayList<>();
        List<Object> list2 = new ArrayList<>();
        list1.add(animal);
        list1.add(dog);
        list1.add(cat);

        list2.add(animal);
        list2.add(dog);
        list2.add(cat);
    }

    //고민2 : 매소드 매개변수에 3개 겍체를 모두 대입할 수 있는지
    public static void method(Animal animal) {

    }

    // 용어고민 ? 1,  인자/인수, 2. 매개변수
}
