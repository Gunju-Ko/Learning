package gunju.learning.algorithm.algospot;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class BoggleTest {

    @Test
    void testBoggle() {
        Boggle b = new Boggle();

        b.embrace(0, "URLPM");
        b.embrace(1, "XPRET");
        b.embrace(2, "GIAET");
        b.embrace(3, "XTNZY");
        b.embrace(4, "XOQRS");

        assertTrue(b.find("PRETTY"));
        assertTrue(b.find("GIRL"));
        assertTrue(b.find("REPEAT"));
        assertTrue(b.find("GIAZAPX"));

        assertFalse(b.find("KARA"));
        assertFalse(b.find("PANDORA"));
    }
}