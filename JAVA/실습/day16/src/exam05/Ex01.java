package exam05;

public class Ex01 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        // Juicer.<Apple>make(appleBox); 지네릭 타입 생략 가능
        Juicer.make(appleBox); // <?> : 메서드 호출시 Apple로 형변환

        FruitBox<Grape> grapeBox = new FruitBox<>();
        grapeBox.add(new Grape());
        grapeBox.add(new Grape());

        // Juicer.<Grape>make(grapeBox); <?> 메서드 호출시 Grape 형변환
        Juicer.make(grapeBox);

//
//        FruitBox<Toy> toyBox = new FruitBox<>();
//        toyBox.add(new Toy());
//        toyBox.add(new Toy());

        //Juicer.make(toyBox);

    }
}
