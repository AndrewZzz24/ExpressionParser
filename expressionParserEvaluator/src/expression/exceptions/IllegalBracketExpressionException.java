package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class IllegalBracketExpressionException extends ExpressionParserException {
    public IllegalBracketExpressionException(String message) {
        super(message);
    }

    public IllegalBracketExpressionException() {
        super();
    }
}
