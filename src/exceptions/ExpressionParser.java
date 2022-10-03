package expression.exceptions;

import expression.*;
import expression.parser.BaseParser;
import expression.parser.StringCharSource;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class ExpressionParser extends BaseParser implements TripleParser {

    private int bracketsCount = 0;

    public ExpressionParser() {
        super(new StringCharSource(""));
    }

    @Override
    public TripleExpression parse(String expression) {
        return startParse(expression);
    }

    public FullExpression parseFullExpression(String expression) {
        return startParse(expression);
    }

    private FullExpression startParse(String expression) {
        startNewParse(new StringCharSource(expression));
        bracketsCount = 0;

        var result = parseExpression();

        if (bracketsCount != 0) {
            throw new IllegalBracketExpressionException("no close bracket");
        }

        return result;
    }

    private FullExpression parseExpression() {

        if (end())
            return null;
        else {
            return parseMinMax();
        }
    }

    private FullExpression parseMinMax() {

        FullExpression result = parseAddSubtract();

        while (true) {

            skipWhitespaces();

            if (take('m')) {
                if (take('i')) {
                    expect('n');
                    result = new Min(result, parseAddSubtract());
                } else {
                    expect("ax");
                    result = new Max(result, parseAddSubtract());
                }
            } else if (end() || test(')')) {
                if (test(')') && bracketsCount == 0)
                    throw new IllegalBracketExpressionException("no opening bracket");
                return result;
            } else {
                throw new OperationMissingExpressionException(String.format(
                        "expected: '%s' , found :'%s'",
                        "min/max operation", take())
                );

            }

        }
    }

    private FullExpression parseAddSubtract() {

        FullExpression result = parseMultiplyDivide();

        while (true) {

            skipWhitespaces();

            if (take('+')) {
                result = new CheckedAdd(result, parseMultiplyDivide());
            } else if (take('-')) {
                result = new CheckedSubtract(result, parseMultiplyDivide());
            } else if (test('m') || end() || test(')')) {
                if (test(')') && bracketsCount == 0)
                    throw new IllegalBracketExpressionException("no opening bracket");
                return result;
            } else {
                throw new OperationMissingExpressionException(String.format(
                        "expected: '%s' , found :'%s'",
                        "add/subtract operation", take())
                );
            }

        }

    }

    private FullExpression parseMultiplyDivide() {

        FullExpression result = parseValue();

        while (true) {

            skipWhitespaces();

            if (take('*')) {
                result = new CheckedMultiply(result, parseValue());
            } else if (take('/')) {
                result = new CheckedDivide(result, parseValue());
            } else if (test('m') || test('+') || test('-') || test(')') || end()) {
                if (test(')') && bracketsCount == 0)
                    throw new IllegalBracketExpressionException("no opening bracket");
                return result;
            } else {
                throw new OperationMissingExpressionException(String.format(
                        "expected: '%s' , found : '%s'",
                        "multiply/divide operation", take())
                );

            }

        }
    }

    private FullExpression parseValue() {

        skipWhitespaces();

        if (test('x') || test('y') || test('z')) {
            return parseVariable();
        } else if (take('-')) {
            if (isDigit())
                return parseConst(true);
            else
                return new CheckedNegate(parseValue());
        } else if (take('c')) {
            expect("ount");
            if (!test('(') && !test(' '))
                throw new ArgumentMissingExpressionException(String.format(
                        "expected: '%s' , found :'%s'",
                        "space or bracket", take())
                );
            return new Count(parseValue());
        } else if (take('l')) {
            expect("0");
            if (!test('(') && !test(' '))
                throw new ArgumentMissingExpressionException(String.format(
                        "expected: '%s' , found :'%s'",
                        "space or bracket", take())
                );
            return new LeadingZeroes(parseValue());
        } else if (take('t')) {
            expect("0");
            if (!test('(') && !test(' '))
                throw new ArgumentMissingExpressionException(String.format(
                        "expected: '%s' , found :'%s'",
                        "space or bracket", take())
                );
            return new TrailingZeroes(parseValue());
        } else if (isDigit()) {
            return parseConst(false);
        } else if (take('(')) {
            bracketsCount++;
            FullExpression result = parseExpression();

            try {
                expect(')');
            } catch (ExpressionParserException e) {
                throw new IllegalBracketExpressionException("no close bracket");
            }

            bracketsCount--;
            return result;
        } else {
            throw new ArgumentMissingExpressionException(String.format(
                    "expected: '%s' , found :'%s'",
                    "argument", take())
            );
        }
    }


    private Const parseConst(boolean isNegative) {

        StringBuilder sb = new StringBuilder();

        if (isNegative)
            sb.append('-');

        int counter = 0;

        while (isDigit()) {

            sb.append(take());

            if (++counter > 10)
                throw new EvaluationExpressionException("constant overflow");

        }

        if (isAlphabetic())
            throw new ConstExpressionException("alphabet letters in digit");

        skipWhitespaces();

        if (isDigit())
            throw new ConstExpressionException("whitespaces in digit");

        if (sb.toString().equals("-"))
            throw new ConstExpressionException("bare - without constant");

        try {
            Integer.parseInt(sb.toString());
        } catch (Exception e) {
            throw new ConstExpressionException("constant overflow");
        }

        return new Const(Integer.parseInt(sb.toString()));

    }

    private Variable parseVariable() {

        char variableName = take();

        if (isAlphabetic())
            throw new VariableNameException("Invalid variable name");

        return new Variable(Character.toString(variableName));
    }
}
