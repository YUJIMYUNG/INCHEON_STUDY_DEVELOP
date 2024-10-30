package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Order order = new Order();
        order.buy();
        order.sell();

        Buyer buyer = order; // 다형성
        buyer.buy();

        Seller seller = order; // 다형성
        seller.sell();
    }
}
