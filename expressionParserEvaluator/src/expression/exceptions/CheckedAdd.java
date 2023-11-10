package expression.exceptions;

import expression.operations.Add;
import expression.expressionInterfaces.FullExpression;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class CheckedAdd extends Add {

    public CheckedAdd(FullExpression leftExpression, FullExpression rightExpression) {
        super(leftExpression, rightExpression);
    }

    @Override
    public int makeOperation(int exprResult1, int exprResult2) {

        checkOperationCorrectness(exprResult1, exprResult2);

        return super.makeOperation(exprResult1, exprResult2);
    }

    public static void checkOperationCorrectness(int exprResult1, int exprResult2) {

        if (exprResult1 > 0 && exprResult2 > 0 || exprResult1 < 0 && exprResult2 < 0) {

            if (exprResult1 > 0 && exprResult1 + exprResult2 <= 0
                    || exprResult1 < 0 && exprResult1 + exprResult2 >= 0)
                throw new OverflowExpressionException(String.format("overflow in add operation in '%s + %s'", exprResult1, exprResult2));

        }

    }
}
