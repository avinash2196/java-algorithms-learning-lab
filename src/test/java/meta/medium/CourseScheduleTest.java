package meta.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    private CourseSchedule courseSchedule;

    @BeforeEach
    void setUp() {
        courseSchedule = new CourseSchedule();
    }

    @Test
    void noCycleSimple() {
        // 0 → 1  (must take 0 before 1)
        assertTrue(courseSchedule.canFinish(2, new int[][]{{1, 0}}));
    }

    @Test
    void directCycle() {
        // 0 → 1 → 0  (cycle)
        assertFalse(courseSchedule.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    @Test
    void noCycleMultipleCourses() {
        // 0→1, 0→2, 1→3, 2→3 — valid DAG
        assertTrue(courseSchedule.canFinish(4,
                new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
    }

    @Test
    void noPrerequisites() {
        assertTrue(courseSchedule.canFinish(5, new int[][]{}));
    }

    @Test
    void selfLoop() {
        assertFalse(courseSchedule.canFinish(1, new int[][]{{0, 0}}));
    }
}
