package meta.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    void setUp() {
        twoSum = new TwoSum();
    }

    // ── HashMap approach ──────────────────────────────────────────────────────

    @Test
    void hashMap_basicCase() {
        int[] result = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertPair(result, 0, 1);
    }

    @Test
    void hashMap_targetAtEnd() {
        int[] result = twoSum.twoSum(new int[]{3, 2, 4}, 6);
        assertPair(result, 1, 2);
    }

    @Test
    void hashMap_duplicateValues() {
        int[] result = twoSum.twoSum(new int[]{3, 3}, 6);
        assertPair(result, 0, 1);
    }

    @Test
    void hashMap_negativeNumbers() {
        int[] result = twoSum.twoSum(new int[]{-1, -2, -3, -4}, -6);
        assertPair(result, 1, 3);
    }

    // ── Sort + binary search approach ─────────────────────────────────────────

    @Test
    void binarySearch_basicCase() {
        int[] result = twoSum.twoSum2(new int[]{2, 7, 11, 15}, 9);
        assertPair(result, 0, 1);
    }

    @Test
    void binarySearch_targetAtEnd() {
        int[] result = twoSum.twoSum2(new int[]{3, 2, 4}, 6);
        assertPair(result, 1, 2);
    }

    // ── Helper ────────────────────────────────────────────────────────────────

    /**
     * Asserts that the result contains exactly the two expected indices,
     * regardless of order.
     */
    private void assertPair(int[] result, int a, int b) {
        assertNotNull(result);
        assertEquals(2, result.length);
        int[] sorted = Arrays.copyOf(result, 2);
        Arrays.sort(sorted);
        int[] expected = {Math.min(a, b), Math.max(a, b)};
        assertArrayEquals(expected, sorted,
                "Expected indices " + a + " and " + b + " but got " + Arrays.toString(result));
    }
}
