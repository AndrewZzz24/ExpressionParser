package expression;

import expression.generic.Evaluator;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Multiply extends AbstractBinaryOperation {

    public Multiply(FullExpression leftExpression, FullExpression rightExpression) {
        super("*", leftExpression, rightExpression);
    }

    @Override
    public int makeOperation(int exprResult1, int exprResult2) {
        return exprResult1 * exprResult2;
    }

    @Override
    protected <T> T evaluateOperation(T exprResult1, T exprResult2, Evaluator<T> evaluator) {
        return evaluator.multiply(exprResult1, exprResult2);
    }
}
