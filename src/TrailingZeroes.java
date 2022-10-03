package expression;

import expression.generic.Evaluator;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class TrailingZeroes extends AbstractUnaryOperation {

    public TrailingZeroes(FullExpression expression) {
        super(expression, "t0");
    }

    @Override
    public int makeOperation(int exprResult) {
        return Integer.numberOfTrailingZeros(exprResult);
    }

    @Override
    protected <T> T evaluateOperation(T exprResult, Evaluator<T> evaluator) {
        return evaluator.trailingZeroes(exprResult);
    }
}
