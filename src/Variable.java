package expression;

import expression.exceptions.VariableNameException;
import expression.generic.Evaluator;

import java.util.Objects;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Variable implements FullExpression {

    private final String variableName;

    public Variable(String variableName) {
        this.variableName = variableName;
    }

    @Override
    public int evaluate(int x, int y, int z) {

        if (variableName.equals("x"))
            return x;

        if (variableName.equals("y"))
            return y;

        if (variableName.equals("z"))
            return z;

        throw new IllegalArgumentException("Unknown variable");
    }

    @Override
    public int evaluate(int x) {
        if (variableName.equals("x"))
            return x;

        throw new IllegalArgumentException("Unknown variable");
    }

    @Override
    public String toString() {
        return variableName;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Variable variable = (Variable) o;

        return Objects.equals(variableName, variable.variableName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(variableName, getClass());
    }

    @Override
    public <T> T evaluate(T x, T y, T z, Evaluator<T> evaluator) {
        return switch (variableName) {
            case "x" -> x;
            case "y" -> y;
            case "z" -> z;
            default -> throw new VariableNameException("invalid variable name");
        };
    }
}
