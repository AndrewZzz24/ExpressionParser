package expression;

import expression.generic.Evaluator;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class LeadingZeroes extends AbstractUnaryOperation {

    public LeadingZeroes(FullExpression expression) {
        super(expression, "l0");
    }

    @Override
    public int makeOperation(int exprResult) {
        return Integer.numberOfLeadingZeros(exprResult);
    }

    @Override
    protected <T> T evaluateOperation(T exprResult, Evaluator<T> evaluator) {
        return evaluator.leadingZeroes(exprResult);
    }
}
