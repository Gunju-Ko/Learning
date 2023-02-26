package gunju.learning.algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class IntegerToRomanTest {

    @Test
    void test() {
        IntegerToRoman sut = new IntegerToRoman();

        assertEquals("III", sut.intToRoman(3));
        assertEquals("LVIII", sut.intToRoman(58));
        assertEquals("MCMXCIV", sut.intToRoman(1994));
    }
}