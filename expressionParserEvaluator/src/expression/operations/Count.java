package expression.operations;

import expression.expressionInterfaces.FullExpression;
import expression.expressionInterfaces.Evaluator;

public class Count extends AbstractUnaryOperation {

    public Count(FullExpression expression) {
        super(expression, "count");
    }

    @Override
    protected int makeOperation(int exprResult) {
        return Integer.bitCount(exprResult);
    }

    @Override
    protected <T> T evaluateOperation(T exprResult, Evaluator<T> evaluator) {
        return evaluator.castValue(String.valueOf(evaluator.count(exprResult)));
    }
}
