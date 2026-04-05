package meta.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrappingWaterTest {

    private TrappingWater trappingWater;

    @BeforeEach
    void setUp() {
        trappingWater = new TrappingWater();
    }

    @Test
    void classicExample() {
        // [0,1,0,2,1,0,1,3,2,1,2,1] → 6
        assertEquals(6, trappingWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void simpleValley() {
        // [4,2,0,3,2,5] → 9
        assertEquals(9, trappingWater.trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    @Test
    void noWaterFlatSurface() {
        assertEquals(0, trappingWater.trap(new int[]{1, 1, 1, 1}));
    }

    @Test
    void noWaterMonotonicallyIncreasing() {
        assertEquals(0, trappingWater.trap(new int[]{1, 2, 3, 4}));
    }

    @Test
    void noWaterMonotonicallyDecreasing() {
        assertEquals(0, trappingWater.trap(new int[]{4, 3, 2, 1}));
    }

    @Test
    void singleBar() {
        assertEquals(0, trappingWater.trap(new int[]{5}));
    }

    @Test
    void emptyArray() {
        assertEquals(0, trappingWater.trap(new int[]{}));
    }
}
