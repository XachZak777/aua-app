package am.aua.app.exception;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException(String msg) {
        super(msg);
    }
}
