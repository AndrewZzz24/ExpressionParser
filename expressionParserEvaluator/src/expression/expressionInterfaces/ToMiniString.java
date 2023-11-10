package expression.expressionInterfaces;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public interface ToMiniString {
    default String toMiniString() {
        return toString();
    }
}
