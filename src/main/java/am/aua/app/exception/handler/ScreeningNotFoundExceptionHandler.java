package am.aua.app.exception.handler;

import am.aua.app.exception.ScreeningNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ScreeningNotFoundExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ScreeningNotFoundException.class)
    public String handleScreeningNotFoundException (ScreeningNotFoundException e) {
        return e.getMessage();
    }
}
