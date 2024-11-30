package am.aua.app.exception.handler;

import am.aua.app.exception.MovieHallNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MovieHallNotFoundExceptionHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MovieHallNotFoundException.class)
    public String handleMovieHallNotFoundException (MovieHallNotFoundException e) {
        return e.getMessage();
    }
}
