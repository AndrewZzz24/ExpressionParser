package expression.exceptions;

import expression.Divide;
import expression.FullExpression;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class CheckedDivide extends Divide {

    public CheckedDivide(FullExpression leftExpression, FullExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int makeOperation(int exprResult1, int exprResult2) {

        checkOperationCorrectness(exprResult1, exprResult2);

        return super.makeOperation(exprResult1, exprResult2);
    }

    public static void checkOperationCorrectness(int exprResult1, int exprResult2) {

        if (exprResult2 == 0)
            throw new DivisionByZeroException(String.format("Division by zero in '%s / %s'", exprResult1, exprResult2));

        if (exprResult1 == Integer.MIN_VALUE && exprResult2 == -1)
            throw new OverflowExpressionException(String.format("overflow in divide operation in '%s / %s'", exprResult1, exprResult2));

    }
}
