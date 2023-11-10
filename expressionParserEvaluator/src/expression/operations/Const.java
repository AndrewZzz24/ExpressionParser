package expression.operations;

import expression.expressionInterfaces.FullExpression;
import expression.expressionInterfaces.Evaluator;

import java.util.Objects;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Const implements FullExpression {

    public final String constValue;

    public Const(int value) {
        this.constValue = Integer.toString(value);
    }

    @Override
    public int evaluate(int x, int y, int z) {
        return Integer.parseInt(constValue);
    }

    @Override
    public String toString() {
        return constValue;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Const aConst = (Const) o;

        return constValue.equals(aConst.constValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(constValue, getClass());
    }


    @Override
    public int evaluate(int x) {
        return Integer.parseInt(constValue);
    }

    @Override
    public <T> T evaluate(T x, T y, T z, Evaluator<T> evaluator) {
         return evaluator.makeConst(constValue);
    }
}
