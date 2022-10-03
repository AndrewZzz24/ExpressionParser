package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class ConstExpressionException extends ExpressionParserException {
    public ConstExpressionException(String message) {
        super(message);
    }

    public ConstExpressionException() {
        super();
    }
}
