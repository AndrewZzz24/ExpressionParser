package expression.generic;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public interface Evaluator<E> {
    E add(E a, E b);

    E divide(E a, E b);

    E subtract(E a, E b);

    E multiply(E a, E b);

    E negate(E exprResult);

    E max(E exprResult1, E exprResult2, Evaluator<E> evaluator);

    E min(E exprResult1, E exprResult2);

    E trailingZeroes(E exprResult);

    E leadingZeroes(E exprResult);

    E makeConst(String constValue);

    E castValue(String value);

    E count(E exprResult);
}
