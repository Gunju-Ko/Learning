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
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i > 0; --i) {
            sb.append(str.charAt(i));
        }
        char first = str.charAt(0);
        if (first == '-') sb.insert(0, first);
        else sb.append(first);
        return sb.toString();
    }
}
