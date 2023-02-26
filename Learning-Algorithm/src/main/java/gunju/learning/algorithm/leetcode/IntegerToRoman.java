package gunju.learning.algorithm.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class IntegerToRoman {

    List<RomanNumeral> numerals = Arrays.asList(
            new RomanNumeral(1, "I"),
            new RomanNumeral(4, "IV"),
            new RomanNumeral(5, "V"),
            new RomanNumeral(9, "IX"),
            new RomanNumeral(10, "X"),
            new RomanNumeral(40, "XL"),
            new RomanNumeral(50, "L"),
            new RomanNumeral(90, "XC"),
            new RomanNumeral(100, "C"),
            new RomanNumeral(400, "CD"),
            new RomanNumeral(500, "D"),
            new RomanNumeral(900, "CM"),
            new RomanNumeral(1000, "M")
    );

    public String intToRoman(int num) {
        return intToRomanRecursive(num);
    }

    private String intToRomanRecursive(int num) {
        if (num == 0) return "";
        RomanNumeral symbol = findNearstSymbol(num);
        if (symbol.value == 1) {
            return IntStream.range(0, num).mapToObj(i -> symbol.symbol).collect(Collectors.joining());
        } else {
            return symbol.symbol + intToRomanRecursive(num - symbol.value);
        }
    }

    public RomanNumeral findNearstSymbol(int num) {
        for (int i = 0; i < numerals.size(); ++i) {
            if (numerals.get(i).value > num) {
                return numerals.get(i - 1);
            }
        }
        return numerals.get(numerals.size() - 1);
    }

    public static class RomanNumeral {
        int value;
        String symbol;

        public RomanNumeral(int value, String symbol) {
            this.value = value;
            this.symbol = symbol;
        }
    }
}
