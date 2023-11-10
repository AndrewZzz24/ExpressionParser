package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class ExpressionParserException extends BaseParserException {

    public ExpressionParserException(String message) {
        super(message);
    }

    public ExpressionParserException() {
        super();
    }
}
