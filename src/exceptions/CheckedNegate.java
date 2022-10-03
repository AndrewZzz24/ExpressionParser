package expression.exceptions;

import expression.FullExpression;
import expression.Negate;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class CheckedNegate extends Negate {

    public CheckedNegate(FullExpression expression) {
        super(expression);
    }

    @Override
    public int makeOperation(int exprResult) {

        checkOperationCorrectness(exprResult);

        return super.makeOperation(exprResult);
    }

    public static void checkOperationCorrectness(int exprResult) {

        if (exprResult == Integer.MIN_VALUE)
            throw new OverflowExpressionException("negate overflow in " + exprResult);

    }
}
