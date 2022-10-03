package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class OperationMissingExpressionException extends ExpressionParserException {

    public OperationMissingExpressionException(String message) {
        super(message);
    }

    public OperationMissingExpressionException() {
        super();
    }
}
