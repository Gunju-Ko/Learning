package gunju.learning.algorithm.programmers.stack;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class FeatureDevelopmentTest {

    @Test
    void testSolution_example1() {
        FeatureDevelopment development = new FeatureDevelopment();
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };

        int[] result = development.solution(progresses, speeds);

        assertEquals(result.length, 2);
        assertEquals(result[0], 2);
        assertEquals(result[1], 1);
    }

    @Test
    void testSolution_example2() {
        FeatureDevelopment development = new FeatureDevelopment();
        int[] progresses = { 95, 90, 99, 99, 80, 99 };
        int[] speeds = { 1, 1, 1, 1, 1, 1 };

        int[] result = development.solution(progresses, speeds);

        assertEquals(result.length, 3);
        assertEquals(result[0], 1);
        assertEquals(result[1], 3);
        assertEquals(result[2], 2);
    }
}