package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class DivisionByZeroException extends EvaluationExpressionException {
    public DivisionByZeroException(String message) {
        super(message);
    }

    public DivisionByZeroException() {
        super();
    }
}
