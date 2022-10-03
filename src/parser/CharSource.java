package expression.parser;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public interface CharSource {
    char next();

    boolean hasNext();

    RuntimeException error(String message);
}
