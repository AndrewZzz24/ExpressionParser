package expression.exceptions;

import expression.FullExpression;
import expression.Subtract;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class CheckedSubtract extends Subtract {

    public CheckedSubtract(FullExpression leftExpression, FullExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int makeOperation(int exprResult1, int exprResult2) {

        checkOperationCorrectness(exprResult1, exprResult2);

        return super.makeOperation(exprResult1, exprResult2);
    }

    public static void checkOperationCorrectness(int exprResult1, int exprResult2) {

        OverflowExpressionException exception = new OverflowExpressionException(String.format("overflow in subtract operation in '%s - %s'", exprResult1, exprResult2));

        if (exprResult1 < 0 && exprResult2 > 0) {

            var result = exprResult1 - exprResult2;

            if (result > 0)
                throw exception;

        } else if (exprResult1 >= 0 && exprResult2 < 0) {

            if (exprResult2 == Integer.MIN_VALUE || exprResult1 - exprResult2 < 0)
                throw exception;

        }

    }
}
