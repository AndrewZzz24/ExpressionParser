package expression.parser;

import expression.exceptions.BaseParserException;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class StringCharSource implements CharSource {

    private final String data;
    private int pos;

    public StringCharSource(String data) {
        this.data = data;
    }

    @Override
    public char next() {
        return data.charAt(pos++);
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public RuntimeException error(String message) {
        return new BaseParserException(String.format("%d : %s", pos + 1, message));
    }
}
