package meta.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    private WordBreak wordBreak;

    @BeforeEach
    void setUp() {
        wordBreak = new WordBreak();
    }

    @Test
    void basicSegmentable() {
        assertTrue(wordBreak.wordBreak("leetcode",
                Arrays.asList("leet", "code")));
    }

    @Test
    void multipleWordsSegmentable() {
        assertTrue(wordBreak.wordBreak("applepenapple",
                Arrays.asList("apple", "pen")));
    }

    @Test
    void notSegmentable() {
        assertFalse(wordBreak.wordBreak("catsandog",
                Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }

    @Test
    void singleWordMatch() {
        assertTrue(wordBreak.wordBreak("hello",
                Arrays.asList("hello")));
    }

    @Test
    void singleWordNoMatch() {
        assertFalse(wordBreak.wordBreak("hello",
                Arrays.asList("world")));
    }
}
