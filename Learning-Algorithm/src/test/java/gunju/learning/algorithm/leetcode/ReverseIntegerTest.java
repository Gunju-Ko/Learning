package gunju.learning.algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class ReverseIntegerTest {

    @Test
    void test() {
        ReverseInteger i = new ReverseInteger();

        assertEquals(321, i.reverse(123));
        assertEquals(-123, i.reverse(-321));
    }

    @Test
    void testOutOfRange() {
        ReverseInteger i = new ReverseInteger();
        assertEquals(21, i.reverse(120));
        assertEquals(0, i.reverse(1534236469));
    }
}