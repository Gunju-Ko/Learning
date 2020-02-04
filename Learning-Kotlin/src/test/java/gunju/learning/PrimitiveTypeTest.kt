package gunju.learning

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PrimitiveTypeTest {

    @Test
    internal fun `test - Nullable Boxing`() {
        val a = 10000

        val boxedA: Int? = a
        val anotherBoxedA: Int? = a

        assertTrue(a == boxedA)
        assertTrue(boxedA == anotherBoxedA)
        @Suppress("IMPLICIT_BOXING_IN_IDENTITY_EQUALS")
        assertFalse(a === boxedA)
        assertFalse(boxedA === anotherBoxedA)
    }
}