package expression.generic;

import java.math.BigInteger;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class BigIntegerEvaluator implements Evaluator<BigInteger> {

    @Override
    public BigInteger add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    @Override
    public BigInteger divide(BigInteger a, BigInteger b) {
        return a.divide(b);
    }

    @Override
    public BigInteger subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    @Override
    public BigInteger multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    @Override
    public BigInteger makeConst(String constValue) {
        return new BigInteger(constValue);
    }

    @Override
    public BigInteger negate(BigInteger exprResult) {
        return exprResult.negate();
    }

    @Override
    public BigInteger max(BigInteger exprResult1, BigInteger exprResult2, Evaluator<BigInteger> evaluator) {
        return exprResult1.max(exprResult2);
    }

    @Override
    public BigInteger trailingZeroes(BigInteger exprResult) {
        throw new UnsupportedOperationException("does not supported for BigInteger type");
    }

    @Override
    public BigInteger leadingZeroes(BigInteger exprResult) {
        throw new UnsupportedOperationException("does not supported for BigInteger type");
    }

    @Override
    public BigInteger min(BigInteger exprResult1, BigInteger exprResult2) {
        return exprResult1.min(exprResult2);
    }

    @Override
    public BigInteger castValue(String value) {
        return new BigInteger(value);
    }

    @Override
    public BigInteger count(BigInteger exprResult) {
        return new BigInteger(String.valueOf(exprResult.bitCount()));
    }
}
