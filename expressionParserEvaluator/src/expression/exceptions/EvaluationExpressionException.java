package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class EvaluationExpressionException extends ExpressionParserException {

    public EvaluationExpressionException(String message) {
        super(message);
    }

    public EvaluationExpressionException() {
        super();
    }
}
