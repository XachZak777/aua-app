package am.aua.app.exception;

public class StaffNotFoundException extends RuntimeException{

    public StaffNotFoundException(String msg) {
        super(msg);
    }
}
