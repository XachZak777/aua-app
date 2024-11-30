package am.aua.app.exception.handler;

import am.aua.app.exception.ReservationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ReservationNotFoundExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ReservationNotFoundException.class)
    public String handleReservationNotFoundException (ReservationNotFoundException e) {
        return e.getMessage();
    }
}
