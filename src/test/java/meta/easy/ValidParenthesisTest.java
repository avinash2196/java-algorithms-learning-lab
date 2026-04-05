package meta.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisTest {

    private ValidParenthesis validator;

    @BeforeEach
    void setUp() {
        validator = new ValidParenthesis();
    }

    @Test
    void singlePairRoundBracket() {
        assertTrue(validator.isValid("()"));
    }

    @Test
    void mixedValidBrackets() {
        assertTrue(validator.isValid("()[]{}"));
    }

    @Test
    void nestedValidBrackets() {
        assertTrue(validator.isValid("{[()]}"));
    }

    @Test
    void wrongOrder() {
        assertFalse(validator.isValid("(]"));
    }

    @Test
    void unclosedBracket() {
        assertFalse(validator.isValid("(["));
    }

    @Test
    void closeWithoutOpen() {
        assertFalse(validator.isValid("]"));
    }

    @Test
    void emptyStringIsValid() {
        assertTrue(validator.isValid(""));
    }
}
