package expression.exceptions;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class VariableNameException extends ExpressionParserException {

    public VariableNameException(String name) {
        super(name);
    }
}
