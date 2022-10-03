package expression;

import expression.exceptions.DivisionByZeroException;
import expression.generic.Evaluator;

import java.util.Objects;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public abstract class AbstractBinaryOperation implements FullExpression {

    protected final String operation;
    protected final FullExpression leftExpression;
    protected final FullExpression rightExpression;

    public AbstractBinaryOperation(String operation, FullExpression leftExpression, FullExpression rightExpression) {
        this.operation = operation;
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }

    @Override
    public int evaluate(int x) {

        int exprResult1 = leftExpression.evaluate(x);
        int exprResult2 = rightExpression.evaluate(x);

        return makeOperation(exprResult1, exprResult2);
    }

    @Override
    public int evaluate(int x, int y, int z) {

        int exprResult1 = leftExpression.evaluate(x, y, z);
        int exprResult2 = rightExpression.evaluate(x, y, z);

        return makeOperation(exprResult1, exprResult2);
    }

    protected abstract int makeOperation(int exprResult1, int exprResult2) throws DivisionByZeroException;

    @Override
    public <T> T evaluate(T x, T y, T z, Evaluator<T> evaluator) {
        return evaluateOperation(leftExpression.evaluate(x, y, z, evaluator), rightExpression.evaluate(x, y, z, evaluator), evaluator);
    }

    protected abstract <T> T evaluateOperation(T exprResult1, T exprResult2, Evaluator<T> evaluator);

    @Override
    public String toString() {
        return "(" + leftExpression.toString() + " " + operation + " " + rightExpression.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        AbstractBinaryOperation that = (AbstractBinaryOperation) o;

        return this.toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftExpression.toString(), rightExpression.toString(), operation, this.getClass());
    }
}
