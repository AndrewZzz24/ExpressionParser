package expression.exceptions;

import expression.TripleExpression;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Main {
    public static void main(String[] args) {

        ExpressionParser expressionParser = new ExpressionParser();
        TripleExpression parsedExpression = null;

        try {
            parsedExpression = expressionParser.parse("1000000*x*x*x*x*x/(x-1)");
        } catch (ExpressionParserException e) {
            System.out.println(e.getMessage());
        }

        if (parsedExpression != null) {

            System.out.println(parsedExpression);

            for (int i = 0; i < 10; i++) {

                try {
                    parsedExpression.evaluate(i, 0, 0);
                } catch (EvaluationExpressionException e) {
                    System.out.println(e.getMessage());
                }

            }
        }
    }
}
