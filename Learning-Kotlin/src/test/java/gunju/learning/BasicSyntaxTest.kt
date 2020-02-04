package gunju.learning

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BasicSyntaxTest {

    @ParameterizedTest
    @CsvSource(
        "0,    1,   1",
        "1,    2,   3",
        "49,  51, 100",
        "1,  100, 101"
    )
    fun `test - sum`(a: Int, b: Int, expectedResult: Int) {
        assertEquals(expectedResult, sum(a, b))
    }

    @ParameterizedTest
    @CsvSource(
        "World, Hello World",
        "Gunju, Hello Gunju"
    )
    fun `test - helloName`(name: String, expectedResult: String) {
        assertEquals(expectedResult, helloName(name))
    }

    @Test
    fun `test - describe`() {
        assertEquals("One", describe(1))
        assertEquals("Long", describe(1L))
        assertEquals("Greeting", describe("Hello"))
        assertEquals("Not a Long", describe("Hello Kotlin"))
    }

    @ParameterizedTest
    @CsvSource(
        "0, true",
        "1, true",
        "10, false",
        "11, false"
    )
    fun `test - singleDigit`(number: Int, expectedResult: Boolean) {
        assertEquals(expectedResult, isSingleDigit(number))
    }

    private fun sum(a: Int, b: Int): Int = a + b

    private fun helloName(name: String): String = "Hello $name"

    private fun describe(obj: Any): String = when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is Long -> "Not a Long"
        else -> "Unknown"
    }

    private fun isSingleDigit(number: Int) = number in 0..9
}