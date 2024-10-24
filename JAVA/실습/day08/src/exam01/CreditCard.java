package exam01;

public class CreditCard {
    int cardNo; // 신용카드 번호
    String holder; // 신용카드 소유자명
    String validDate; // 유효기간

    public CreditCard(int _cardNo, String _holder, String _validDate){
        cardNo = _cardNo;
        holder = _holder;
        validDate = _validDate;
    }

    void showInfo() {
        System.out.printf("cardNo=%d, holder=%s, validDate=%s%n", cardNo, holder, validDate);
    }
}
