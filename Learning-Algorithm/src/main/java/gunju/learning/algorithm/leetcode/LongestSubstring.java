package gunju.learning.algorithm.leetcode;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int result = 1;
        for (int i =  0; i < s.length(); ++i) {
            int length = 1;
            boolean[] mark = new boolean[500];
            mark[s.charAt(i)] = true;
            for (int j = i + 1; j < s.length(); ++j) {
                if (mark[s.charAt(j)]) {
                    break;
                } else {
                    mark[s.charAt(j)] = true;
                    length++;
                }
            }
            if (length > result) {
                result = length;
            }
        }
        return result;
    }

}
