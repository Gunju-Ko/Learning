package gunju.learning.algorithm.algospot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class Template {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int c = s.nextInt();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < c; ++i) {
            String input = s.next();
            result.add(solve(input));
        }

        for (String value : result) {
            System.out.println(value);
        }
    }

    public static String solve(String input) {
        return input;
    }
}
