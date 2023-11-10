package expression.operations;

import expression.expressionInterfaces.FullExpression;
import expression.expressionInterfaces.Evaluator;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Add extends AbstractBinaryOperation {

    public Add(FullExpression leftExpression, FullExpression rightExpression) {
        super("+", leftExpression, rightExpression);
    }

    @Override
    protected int makeOperation(int exprResult1, int exprResult2) {
        return exprResult1 + exprResult2;
    }

    @Override
    protected <T> T evaluateOperation(T exprResult1, T exprResult2, Evaluator<T> evaluator) {
        return evaluator.add(exprResult1, exprResult2);
    }
}
