package am.aua.app.exception;

public class ReservationNotFoundException extends RuntimeException{

    public ReservationNotFoundException(String msg) {
        super(msg);
    }
}
