package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class ArgumentMissingExpressionException extends ExpressionParserException {
    public ArgumentMissingExpressionException(String message) {
        super(message);
    }

    public ArgumentMissingExpressionException() {
        super();
    }
}
