package expression.operations;

import expression.expressionInterfaces.FullExpression;
import expression.expressionInterfaces.Evaluator;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Max extends AbstractBinaryOperation {

    public Max(FullExpression leftExpression, FullExpression rightExpression) {
        super("max", leftExpression, rightExpression);
    }

    @Override
    public int makeOperation(int exprResult1, int exprResult2) {
        return Math.max(exprResult1, exprResult2);
    }

    @Override
    protected <T> T evaluateOperation(T exprResult1, T exprResult2, Evaluator<T> evaluator) {
        return evaluator.max(exprResult1, exprResult2, evaluator);
    }
}
