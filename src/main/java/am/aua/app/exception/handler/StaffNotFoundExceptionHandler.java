package am.aua.app.exception.handler;

import am.aua.app.exception.StaffNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StaffNotFoundExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(StaffNotFoundException.class)
    public String handleStaffNotFoundException (StaffNotFoundException e) {
        return e.getMessage();
    }
}
