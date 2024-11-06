package exam06;

public class Box<T, U> { // 지네릭 클래스
    private T item; // Box<자료형1, 자료형2> box = new Box<>();
    private U item2;

    public void setItem(T item1, U item2){

    }

    // 메서드 호출 시 method(Stirng, LocalData) - 지네릭 메서드
    public <T, U> void method(T t, U u){

    }
}
