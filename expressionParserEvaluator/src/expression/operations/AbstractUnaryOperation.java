package expression.operations;

import expression.expressionInterfaces.FullExpression;
import expression.expressionInterfaces.Evaluator;

import java.util.Objects;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public abstract class AbstractUnaryOperation implements FullExpression {

    protected final FullExpression expression;
    protected final String operationSymbol;

    protected AbstractUnaryOperation(FullExpression expression, String operationSymbol) {
        this.expression = expression;
        this.operationSymbol = operationSymbol;
    }

    @Override
    public int evaluate(int x) {
        int exprResult = expression.evaluate(x);
        return makeOperation(exprResult);
    }

    @Override
    public int evaluate(int x, int y, int z) {

        int exprResult = expression.evaluate(x, y, z);
        return makeOperation(exprResult);

    }

    protected abstract int makeOperation(int exprResult);

    @Override
    public <T> T evaluate(T x, T y, T z, Evaluator<T> evaluator) {
        return evaluateOperation(expression.evaluate(x, y, z, evaluator), evaluator);
    }

    protected abstract <T> T evaluateOperation(T exprResult, Evaluator<T> evaluator);

    @Override
    public String toString() {
        return operationSymbol + "(" + expression.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AbstractUnaryOperation that = (AbstractUnaryOperation) o;

        return this.expression.toString().equals(that.expression.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression.toString(), operationSymbol, getClass());
    }
}
