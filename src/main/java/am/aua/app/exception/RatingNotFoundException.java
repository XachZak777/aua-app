package am.aua.app.exception;

public class RatingNotFoundException extends RuntimeException {
    public RatingNotFoundException(String msg) {
        super(msg);
    }
}
