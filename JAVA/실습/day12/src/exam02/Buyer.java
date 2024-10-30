package exam02;

public interface Buyer {
    void buy();

    default void order(){ // public 범위
        System.out.println("Buyer - 주문");
        privateMethod();
    }

    private void privateMethod() {
        System.out.println("private 메서드");
    }

    public static void staticMethod() { // interface는 무조건 public 이기 때문에 생략 가능!
        System.out.println("static 메서드");
    }
}
