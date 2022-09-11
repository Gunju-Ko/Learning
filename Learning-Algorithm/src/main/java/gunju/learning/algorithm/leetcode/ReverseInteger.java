package gunju.learning.algorithm.leetcode;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class ReverseInteger {

    public int reverse(int x) {
        String s = String.valueOf(x);
        String r = reverse(s);
        try {
            return Integer.parseInt(r);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private String reverse(String str) {
        if (str.charAt(0) == '-') {
            return "-" + reverse(str.substring(1));
        } else {
            return new StringBuilder(str).reverse().toString();
        }
    }
}
