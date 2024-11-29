package am.aua.app.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String msg) {
        super(msg);
    }
}
