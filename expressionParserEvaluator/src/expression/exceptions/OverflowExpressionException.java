package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class OverflowExpressionException extends EvaluationExpressionException {

    public OverflowExpressionException(String message) {
        super(message);
    }

    public OverflowExpressionException() {
        super();
    }

}
