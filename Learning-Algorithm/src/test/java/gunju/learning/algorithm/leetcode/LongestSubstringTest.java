package gunju.learning.algorithm.leetcode;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class LongestSubstringTest {

    @Test
    void lengthOfLongestSubstring_example1() {
        int result = new LongestSubstring().lengthOfLongestSubstring("abcabcbb");

        assertEquals(result, 3);
    }

    @Test
    void lengthOfLongestSubstring_example2() {
        int result = new LongestSubstring().lengthOfLongestSubstring("bbbbb");

        assertEquals(result, 1);
    }

    @Test
    void lengthOfLongestSubstring_example3() {
        int result = new LongestSubstring().lengthOfLongestSubstring("pwwkew");

        assertEquals(result, 3);
    }

    @Test
    void lengthOfLongestSubstring_example4() {
        int result = new LongestSubstring().lengthOfLongestSubstring("");

        assertEquals(result, 0);
    }
}