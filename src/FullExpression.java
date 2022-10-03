package expression;

import expression.generic.Evaluator;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public interface FullExpression extends TripleExpression, Expression {
    <T> T evaluate(T x, T y, T z, Evaluator<T> evaluator);
}
