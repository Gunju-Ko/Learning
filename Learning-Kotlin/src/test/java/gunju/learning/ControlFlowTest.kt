package gunju.learning

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ControlFlowTest {

    @Test
    fun `test toString`() {
        assertThat(toString(1)).isEqualTo("1")
        assertThat(toString(2)).isEqualTo("2")
        assertThat(toString(3)).isEqualTo("3")
        assertThat(toString(4)).isEqualTo("Unknown")
    }

    @Test
    fun `test isSingleDigit`() {
        assertThat(isSingleDigit(0)).isTrue()
        assertThat(isSingleDigit(9)).isTrue()
        assertThat(isSingleDigit(10)).isFalse()
    }

    private fun toString(x: Any): String {
        return when (x) {
            1 -> "1"
            2 -> "2"
            3 -> "3"
            else -> "Unknown"
        }
    }

    private fun isSingleDigit(x: Number): Boolean {
        return when (x) {
            in 0..9 -> true
            else -> false
        }
    }
}