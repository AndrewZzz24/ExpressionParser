package expression.generic;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class DoubleEvaluator implements Evaluator<Double> {

    @Override
    public Double add(Double a, Double b) {
        return a + b;
    }

    @Override
    public Double divide(Double a, Double b) {
        return a / b;
    }

    @Override
    public Double subtract(Double a, Double b) {
        return a - b;
    }

    @Override
    public Double multiply(Double a, Double b) {
        return a * b;
    }

    @Override
    public Double makeConst(String constValue) {
        return Double.parseDouble(constValue);
    }

    @Override
    public Double negate(Double exprResult) {
        return -exprResult;
    }

    @Override
    public Double max(Double exprResult1, Double exprResult2, Evaluator<Double> evaluator) {
        return Math.max(exprResult1, exprResult2);
    }

    @Override
    public Double trailingZeroes(Double exprResult) {
        throw new UnsupportedOperationException("trailing zeroes are not supported for double type");
    }

    @Override
    public Double leadingZeroes(Double exprResult) {
        throw new UnsupportedOperationException("leading zeroes are not supported for double type");
    }

    @Override
    public Double min(Double exprResult1, Double exprResult2) {
        return Math.min(exprResult1, exprResult2);
    }

    @Override
    public Double castValue(String value) {
        return Double.parseDouble(value);
    }

    @Override
    public Double count(Double exprResult) {
        return (double) Long.bitCount(Double.doubleToLongBits(exprResult));
    }
}
