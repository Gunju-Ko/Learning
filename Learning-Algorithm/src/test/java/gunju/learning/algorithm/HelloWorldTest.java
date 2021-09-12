package gunju.learning.algorithm;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class HelloWorldTest {

    @Test
    void testHelloWorld() {
        HelloWorld helloWorld = new HelloWorld();

        assertEquals(helloWorld.getMessage(), "Hello World");
    }
}