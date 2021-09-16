package gunju.learning.algorithm;

import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
public class RandomTest {
    private final Random random = new Random();

    @Test
    public void testRandom() {
        int success = 0;
        int fail = 0;

        for (int i = 0; i < 10000; ++i) {
            if (random.nextBoolean()) {
                success++;
            } else {
                fail++;
            }
        }

        System.out.println("Success : " + success);
        System.out.println("Fail : " + fail);
    }
}
