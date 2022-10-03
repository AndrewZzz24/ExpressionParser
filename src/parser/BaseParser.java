package expression.parser;

import expression.exceptions.BaseParserException;

/**
 * @author Andrew Zmushko (andrewzmushko@gmail.com)
 */
public class BaseParser {

    private static final char END = 0;
    private CharSource source;
    private char ch;

    protected BaseParser(CharSource source) {

        startNewParse(source);

    }

    protected void startNewParse(CharSource source) {

        this.source = source;
        take();

    }

    protected boolean test(final char expected) {

        return ch == expected;

    }

    protected char take() {

        char result = ch;
        ch = source.hasNext() ? source.next() : END;
        return result;

    }

    protected boolean take(final char expected) {

        if (test(expected)) {
            take();
            return true;
        } else {
            return false;
        }

    }

    protected void expect(final char expected) {
        if (!take(expected)) {
            throw error(String.format(
                    "expected: '%s' , found :'%s'",
                    expected, ch)
            );
        }
    }

    protected void expect(final String expected) {

        for (var c : expected.toCharArray()) {
            if (!take(c))
                throw error(String.format(
                        "expected: '%s' , found :'%s'",
                        expected, ch)
                );
        }

    }

    protected boolean end() {
        return test(END);
    }

    protected void skipWhitespaces() {

        while (Character.isWhitespace(ch)) {
            take();
        }

    }

    protected boolean isDigit() {
        return Character.isDigit(ch);
    }

    protected boolean isAlphabetic() {
        return Character.isAlphabetic(ch);
    }

    protected BaseParserException error(String message) {
        return new BaseParserException(String.format("%s", message));
    }

}
