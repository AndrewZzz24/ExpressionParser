package expression;

import expression.expressionInterfaces.Expression;
import expression.operations.*;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class Main {
    public static void main(String[] args) {

        if (args.length != 1) {
            throw new IllegalArgumentException("  ");
        }

        Expression expression = new Add(
                new Subtract(
                        new Multiply(
                                new Variable("x"),
                                new Variable("x")
                        ),
                        new Multiply(
                                new Const(2),
                                new Variable("x")
                        )
                ),
                new Const(1)
        );
        System.out.println(expression);
        System.out.println(expression.evaluate(Integer.parseInt(args[0])));
    }

}
