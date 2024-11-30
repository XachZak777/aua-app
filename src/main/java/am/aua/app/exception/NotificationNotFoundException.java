package am.aua.app.exception;

public class NotificationNotFoundException extends RuntimeException {
    public NotificationNotFoundException(String msg) {
        super(msg);
    }
}
