package expression.parser;

import expression.expressionInterfaces.TripleExpression;
import expression.exceptions.ExpressionParser;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Main {
    public static void main(String[] args) {

        ExpressionParser expressionParser = new ExpressionParser();

        TripleExpression expression = expressionParser.parse("x * (x - 2)*x + 1");

        System.out.println(expression.toString());
        System.out.println(expression.evaluate(0, 0, 0));
    }
}
