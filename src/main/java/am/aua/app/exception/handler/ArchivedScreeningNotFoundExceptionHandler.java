package am.aua.app.exception.handler;

import am.aua.app.exception.ArchivedScreeningNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ArchivedScreeningNotFoundExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ArchivedScreeningNotFoundException.class)
    public String handleArchievedScreeningNotFoundException (ArchivedScreeningNotFoundException e) {
        return e.getMessage();
    }
}
