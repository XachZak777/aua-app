package am.aua.app.exception.handler;


import am.aua.app.exception.ActorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class ActorNotFoundExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ActorNotFoundException.class)
    public String handleActorNotFoundException (ActorNotFoundException e) {
        return e.getMessage();
    }
}
