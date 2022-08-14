package gunju.learning.algorithm;


/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class QuadTree {

    public String reverse(String input) {
        if (input.length() == 1) return input;
        String[] divided = divide(input);
        return "x" + reverse(divided[2]) + reverse(divided[3]) + reverse(divided[0]) + reverse(divided[1]);
    }

    private String[] divide(String input) {
        String[] result = new String[4];
        int resultIndex = 0;
        int inputIndex = 1;
        while (inputIndex < input.length()) {
            if (input.charAt(inputIndex) != 'x') {
                result[resultIndex] = String.valueOf(input.charAt(inputIndex));
                resultIndex++; inputIndex++;
            } else {
                String x = mergeX(input, inputIndex + 1);
                result[resultIndex] = x;
                resultIndex++;
                inputIndex += x.length();
            }
        }
        return result;
    }

    private String mergeX(String input, int startIndex) {
        StringBuilder sb = new StringBuilder();
        int inputIndex = startIndex;
        int addCount = 0;
        while (addCount < 4) {
            if (input.charAt(inputIndex) != 'x') {
                sb.append(input.charAt(inputIndex));
                inputIndex++;
            } else {
                String x = mergeX(input, inputIndex + 1);
                sb.append(x);
                inputIndex += x.length();
            }
            addCount++;
        }
        return "x" + sb;
    }
}
