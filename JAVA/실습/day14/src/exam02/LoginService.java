package exam02;

public class LoginService {
    public void login(String userId, String password) /*throws UserIdNotFountException, PasswordMismatchException*/{ // 예외 전가 - 호출하는 쪽에서 처리를 미루기
        // userId = "user01", password = 1234

        if (!userId.equals("user01")) { // userId가 user01로 일치하지 않을 때
            throw new UserIdNotFountException("아이디가 일치하지 않습니다.");
        }

        if (!password.equals("1234")) {
            throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
        }

    }
}
