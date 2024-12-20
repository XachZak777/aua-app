package am.aua.app.exception.handler;

import am.aua.app.exception.RatingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RatingNotFoundExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RatingNotFoundException.class)
    public String handleRatingNotFoundException (RatingNotFoundException e) {
        return e.getMessage();
    }
}
