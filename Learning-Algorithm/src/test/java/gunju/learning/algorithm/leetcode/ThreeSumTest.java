package gunju.learning.algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class ThreeSumTest {

    @Test
    void test_noPossibleAnswer() {
        ThreeSum sut = new ThreeSum();

        List<List<Integer>> result = sut.threeSum(new int[]{0, 1, 1});

        assertTrue(result.isEmpty());
    }

    @Test
    void test_PossibleAnswer() {
        ThreeSum sut = new ThreeSum();

        List<List<Integer>> result = sut.threeSum(new int[]{0, 0, 0});

        assertEquals(1, result.size());
    }

    @Test
    void testCase1() {
        ThreeSum sut = new ThreeSum();

        List<List<Integer>> result = sut.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, result.size());
    }

    @Test
    void testCase2() {
        ThreeSum sut = new ThreeSum();

        List<List<Integer>> result = sut.threeSum(new int[]{-1, 0, 1, 0});

        assertEquals(1, result.size());
    }

    @Test
    void testCase3() {
        ThreeSum sut = new ThreeSum();

        List<List<Integer>> result = sut.threeSum(new int[]{0, 0, 0, 0});

        assertEquals(1, result.size());
    }
}