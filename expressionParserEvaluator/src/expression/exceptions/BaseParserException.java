package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class BaseParserException extends RuntimeException{

    private final String message;

    public BaseParserException(String message) {
        this.message = message;
    }

    public BaseParserException() {
        message = this.getClass().toString();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
