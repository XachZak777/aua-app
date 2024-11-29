package am.aua.app.exception;

public class ActorNotFoundException extends RuntimeException{

    public ActorNotFoundException(String msg) {
        super(msg);
    }

}