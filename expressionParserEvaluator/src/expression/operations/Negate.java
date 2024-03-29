package expression.operations;

import expression.expressionInterfaces.FullExpression;
import expression.expressionInterfaces.Evaluator;

public class Negate extends AbstractUnaryOperation {

    public Negate(FullExpression expression) {
        super(expression, "-");
    }

    @Override
    public int makeOperation(int exprResult) {
        return -exprResult;
    }

    @Override
    protected <T> T evaluateOperation(T exprResult, Evaluator<T> evaluator) {
        return evaluator.negate(exprResult);
    }
}
