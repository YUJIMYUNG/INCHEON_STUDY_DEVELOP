package exam02;

public interface Seller {
    int num = 10; // public static final - 컴파일러가 자동 추가 (정적 상수)

    void sell();

    default void order() {
        System.out.println("Seller - 주문");
    }

}
