package expression.generic;

import expression.FullExpression;
import expression.exceptions.ExpressionParser;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */

public class GenericTabulator implements Tabulator {

    public static void main(String[] args) {

        if (args.length != 2)
            throw new IllegalArgumentException("arg1 -- evaluation type; arg2  -- expression for evaluation");

        String evaluationType = args[0];
        String expression = args[1];
        Object[][][] result = new GenericTabulator().tabulate(evaluationType, expression, -2, 2, -2, 2, -2, 2);

        for (Object[][] objects : result) {
            for (Object[] object : objects) {
                for (Object o : object) {
                    System.out.println(o);
                }
            }
        }
    }

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) {
        FullExpression parsedExpression = new ExpressionParser().parseFullExpression(expression);
        Evaluator<?> evaluator = getEvaluator(mode);
        return makeTabulation(parsedExpression, evaluator, x1, x2, y1, y2, z1, z2);
    }

    private <T> Object[][][] makeTabulation(FullExpression parsedExpression, Evaluator<T> evaluator, int x1, int x2, int y1, int y2, int z1, int z2) {
        Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                for (int k = z1; k <= z2; k++) {
                    try {
                        result[i - x1][j - y1][k - z1] = parsedExpression.evaluate(
                                evaluator.castValue(Integer.toString(i)),
                                evaluator.castValue(Integer.toString(j)),
                                evaluator.castValue(Integer.toString(k)),
                                evaluator
                        );
                    } catch (Exception e) {
                        result[i - x1][j - y1][k - z1] = null;
                    }
                }
            }
        }
        return result;
    }

    private Evaluator<?> getEvaluator(String mode) {
        return switch (mode) {
            case "i" -> new IntEvaluator(true);
            case "d" -> new DoubleEvaluator();
            case "bi" -> new BigIntegerEvaluator();
            default -> throw new IllegalArgumentException("invalid mode");
        };
    }
}
