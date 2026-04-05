package meta.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    private WordLadder wordLadder;

    @BeforeEach
    void setUp() {
        wordLadder = new WordLadder();
    }

    @Test
    void shortestPath() {
        // hit → hot → dot → dog → cog = 5 steps
        assertEquals(5, wordLadder.ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    @Test
    void endWordNotInList() {
        assertEquals(0, wordLadder.ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    @Test
    void directOneLetterChange() {
        assertEquals(2, wordLadder.ladderLength("a", "b",
                Arrays.asList("b")));
    }

    @Test
    void noPathExists() {
        assertEquals(0, wordLadder.ladderLength("hit", "xyz",
                Arrays.asList("hot", "dot")));
    }
}
