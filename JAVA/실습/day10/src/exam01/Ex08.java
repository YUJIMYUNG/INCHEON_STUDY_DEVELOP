package exam01;

public class Ex08 {
    public static void main(String[] args) {
        // JDK17 - instanceof를 사용하는 경우. 많은 경우가 하위 클래스로 형변환 하기 전에 체크 해볼때 사용한다.
        A ac = new C();

        if(ac instanceof C c){

        }

//      위와 같음
//        if(ac instanceof C){
//            C c1 = (C)ac; // 본질적으로 출처가 다르기때문에 형변환 불가능 (error)
//        }
    }
}
