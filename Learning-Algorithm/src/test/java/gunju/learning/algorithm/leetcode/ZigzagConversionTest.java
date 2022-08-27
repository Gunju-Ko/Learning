package gunju.learning.algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class ZigzagConversionTest {

    @Test
    void test() {
        ZigzagConversion conversion = new ZigzagConversion();

        assertEquals("A", conversion.convert("A", 1));
        assertEquals("PAYPALISHIRING", conversion.convert("PAYPALISHIRING", 1));
        assertEquals("PAHNAPLSIIGYIR", conversion.convert("PAYPALISHIRING", 3));
        assertEquals("PINALSIGYAHRPI", conversion.convert("PAYPALISHIRING", 4));
    }
}