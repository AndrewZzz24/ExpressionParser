package expression.exceptions;

import expression.*;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class CheckedMultiply extends Multiply {

    public CheckedMultiply(FullExpression leftExpression, FullExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int makeOperation(int exprResult1, int exprResult2) {

        checkOperationCorrectness(exprResult1, exprResult2);

        return super.makeOperation(exprResult1, exprResult2);
    }

    public static void checkOperationCorrectness(int exprResult1, int exprResult2) {

        OverflowExpressionException exception = new OverflowExpressionException(String.format("overflow in multiply operation in '%s * %s'", exprResult1, exprResult2));

        if (exprResult1 == Integer.MIN_VALUE && exprResult2 == -1) {
            throw exception;
        }

        if (exprResult1 > 0 && exprResult2 > 0 || exprResult1 < 0 && exprResult2 < 0) {
            if (exprResult1 > 0 && exprResult1 > Integer.MAX_VALUE / exprResult2) {
                throw exception;
            }
            if (exprResult1 < 0 && exprResult1 < Integer.MAX_VALUE / exprResult2) {
                throw exception;
            }
        }

        if (exprResult1 > 0 && exprResult2 < 0 || exprResult1 < 0 && exprResult2 > 0) {
            if (exprResult1 > 0 && exprResult2 < Integer.MIN_VALUE / exprResult1) {
                throw exception;
            }
            if (exprResult1 < 0 && exprResult1 < Integer.MIN_VALUE / exprResult2) {
                throw exception;
            }
        }

    }
}
