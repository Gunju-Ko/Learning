package gunju.learning

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ReturnAndJumpTest {

    @Test
    fun `test - 람다식에서 리턴시 nearest enclosing 함수가 리턴됨`() {
        val list = listOf(1, 2, 3)

        list.forEach {
            if (it == 3) return
        }

        Assertions.fail<Any>("람다식에서 리턴시 nearest enclosing 함수가 리턴됨 ")
    }

    @Test
    fun `test - 람다식에서 label 리턴이 가능함`() {
        val list = listOf(1, 2, 3)
        var loopCount = 0
        list.forEach {
            if (it == 3) return@forEach
            loopCount++
        }
        assertThat(loopCount).isEqualTo(2)
    }

    @Test
    fun `test - 람다식(map)에서 리턴할 경우 nearest enclosing 함수가 리턴됨`() {
        val list = listOf(1, 2, 3)
        list.map {
            if (it == 3) return
        }
        Assertions.fail<Any>("람다식에서 리턴시 nearest enclosing 함수가 리턴됨 ")
    }

    @Test
    fun `test - 람다식(map)에서 label 리턴 가능합니다`() {
        val list = listOf(1, 2, 3)
        val contents = list.map {
            "Contents : $it"
        }
        assertThat(contents.size).isEqualTo(3)
    }
}