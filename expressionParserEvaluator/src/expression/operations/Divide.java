package expression.operations;

import expression.expressionInterfaces.FullExpression;
import expression.exceptions.DivisionByZeroException;
import expression.expressionInterfaces.Evaluator;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Divide extends AbstractBinaryOperation {

    public Divide(FullExpression leftExpression, FullExpression rightExpression) {
        super("/", leftExpression, rightExpression);
    }

    @Override
    public int makeOperation(int exprResult1, int exprResult2) throws DivisionByZeroException {
        return exprResult1 / exprResult2;
    }

    @Override
    protected <T> T evaluateOperation(T exprResult1, T exprResult2, Evaluator<T> evaluator) {
        return evaluator.divide(exprResult1, exprResult2);
    }
}
