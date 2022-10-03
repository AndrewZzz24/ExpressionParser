package expression.generic;

import expression.exceptions.*;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class IntEvaluator implements Evaluator<Integer> {

    private final boolean checkOverflow;

    public IntEvaluator(boolean checkOverflow) {
        this.checkOverflow = checkOverflow;
    }

    @Override
    public Integer add(Integer a, Integer b) {
        if (checkOverflow)
            CheckedAdd.checkOperationCorrectness(a, b);
        return a + b;
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        if (checkOverflow)
            CheckedDivide.checkOperationCorrectness(a, b);
        return a / b;
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        if (checkOverflow)
            CheckedSubtract.checkOperationCorrectness(a, b);
        return a - b;
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        if (checkOverflow)
            CheckedMultiply.checkOperationCorrectness(a, b);
        return a * b;
    }

    @Override
    public Integer makeConst(String constValue) {
        return Integer.parseInt(constValue);
    }

    @Override
    public Integer negate(Integer exprResult) {
        if (checkOverflow)
            CheckedNegate.checkOperationCorrectness(exprResult);
        return -exprResult;
    }

    @Override
    public Integer max(Integer exprResult1, Integer exprResult2, Evaluator<Integer> evaluator) {
        return Math.max(exprResult1, exprResult2);
    }

    @Override
    public Integer min(Integer exprResult1, Integer exprResult2) {
        return Math.min(exprResult1, exprResult2);
    }

    @Override
    public Integer trailingZeroes(Integer exprResult) {
        return Integer.numberOfTrailingZeros(exprResult);
    }

    @Override
    public Integer leadingZeroes(Integer exprResult) {
        return Integer.numberOfLeadingZeros(exprResult);
    }

    @Override
    public Integer castValue(String value) {
        return Integer.parseInt(value);
    }

    @Override
    public Integer count(Integer exprResult) {
        return Integer.bitCount(exprResult);
    }
}
