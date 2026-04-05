package meta.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbStairsTest {

    private ClimbStairs climbStairs;

    @BeforeEach
    void setUp() {
        climbStairs = new ClimbStairs();
    }

    @Test
    void oneStep() {
        assertEquals(1, climbStairs.climbStairs(1));
    }

    @Test
    void twoSteps() {
        // Either (1,1) or (2) → 2 ways
        assertEquals(2, climbStairs.climbStairs(2));
    }

    @Test
    void threeSteps() {
        // (1,1,1), (1,2), (2,1) → 3 ways
        assertEquals(3, climbStairs.climbStairs(3));
    }

    @Test
    void fiveSteps() {
        assertEquals(8, climbStairs.climbStairs(5));
    }

    @Test
    void tenSteps() {
        assertEquals(89, climbStairs.climbStairs(10));
    }
}
