package exam02;

public class Ex01 {
    public static void main(String[] args) {
        LoginService service = new LoginService();
        // service.login 메서드가 사용하는 상황은 다양할 수 있다.
        // 일반회원 페이지, 관리자 페이지 등등...
        // 그에 따른 성공시 처리와 실패시 처리가 다를 수 있다.
        // 호출되는 쪽에서 처리가 달라지는 경우라면, 메서드 내부에서 처리하는것이 아니라
        // 호출하는 쪽에서 예외에 대한 처리를 하는것이 적합하다.
//        try {
        //RuntimeException을 throws함으로서 try-catch를 사용하지 않아도 유연하게 처리 가능
            service.login("user01", "123");
            System.out.println("로그인 성공...");
//        } catch (UserIdNotFountException | PasswordMismatchException e){
//            System.out.println(e.getMessage());
//        }
    }
}
