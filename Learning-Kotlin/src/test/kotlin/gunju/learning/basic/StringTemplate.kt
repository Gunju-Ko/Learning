package gunju.learning.basic

import org.junit.jupiter.api.Test

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class StringTemplate {

    @Test
    internal fun test() {
        val a = Math.random()
        println("Hello ${if (a > 0.5) "0.5보다 큽니다." else "0.5보다 작습니다"}")
    }
}