package gunju.learning

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IteratorTest {

    @Test
    fun `test iterator`() {
        val members = Members()
        members.addMember(Member("1", "gunju"))
        members.addMember(Member("2", "sanyoung"))

        var loopCount = 0
        for (member in members) {
            loopCount++
        }
        assertThat(loopCount).isEqualTo(2)
    }

    class Members {
        private val members: MutableList<Member> = mutableListOf()

        fun addMember(member: Member) {
            members.add(member)
        }

        operator fun iterator(): MemberIterator {
            return MemberIterator(members)
        }
    }

    class MemberIterator(private val members: List<Member>) : Iterator<Member> {
        private var index = 0
        override fun hasNext(): Boolean {
            return index < members.size
        }

        override fun next(): Member {
            return members[index++]
        }
    }

    data class Member(
        val id: String,
        val name: String
    )
}