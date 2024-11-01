package exam02;

public class PasswordMismatchException extends RuntimeException /*extends Exception*/{
    public PasswordMismatchException(String message){
        super(message);
    }
}
