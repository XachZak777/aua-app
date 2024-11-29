package am.aua.app.exception;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String msg) {
        super(msg);
    }
}
