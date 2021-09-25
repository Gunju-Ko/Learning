package gunju.learning.basic

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

/**
 * @author 고건주 (gunju.ko@navercorp.com)
 */
class Variable {

    @Test
    @DisplayName("val 초기화 테스트")
    internal fun test1() {
        val message: String
        val a = Math.random()
        if (a > 0.5) {
            message = "0.5보다 크다"
        } else {
            message = "0.5보다 작다"
        }

        println(message)
    }
}