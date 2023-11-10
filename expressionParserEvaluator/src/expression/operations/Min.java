package expression.operations;

import expression.expressionInterfaces.FullExpression;
import expression.expressionInterfaces.Evaluator;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Min extends AbstractBinaryOperation {

    public Min(FullExpression leftExpression, FullExpression rightExpression) {
        super("min", leftExpression, rightExpression);
    }

    @Override
    public int makeOperation(int exprResult1, int exprResult2) {
        return Math.min(exprResult1, exprResult2);
    }

    @Override
    protected <T> T evaluateOperation(T exprResult1, T exprResult2, Evaluator<T> evaluator) {
        return evaluator.min(exprResult1, exprResult2);
    }
}
