package onboarding

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class `문제 7번의` {

    @Nested
    inner class `validateId 메소드는` {

        @Nested
        inner class `길이가 1 이상 30 이하가 아닌 문자열이 주어지면` {
            private val id = "a".repeat(31)

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateId(id) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `알파벳 소문자가 아닌 문자를 포함한 문자열이 주어지면` {
            private val id = "A".repeat(10)

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateId(id) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }

    @Nested
    inner class `validateFriends 메소드는` {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `친구 관계 정보가 1 이상 10_000 이하가 아니면` {
            private fun friends() = listOf(
                Arguments.of((1..10_001).map { listOf("id", "id") }),
                Arguments.of(listOf<List<String>>()),
            )

            @ParameterizedTest
            @MethodSource("friends")
            fun `예외를 던진다`(friends: List<List<String>>) {
                assertThatThrownBy { validateFriends(friends) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessage("친구 관계 정보는 1 이상 10,000 이하여야 합니다.")
            }
        }

        @Nested
        inner class `친구 관계 정보의 길이가 2가 아닌 정보가 주어지면` {
            private val friends = listOf(listOf("idone", "idtwo", "idthree"))

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateFriends(friends) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessage("친구 관계 정보는 길이가 2여야 합니다.")
            }
        }

        @Nested
        inner class `동일한 친구 관계가 주어지면` {
            private val friends = (1..2).map { listOf("idone", "idtwo") }

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateFriends(friends) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessage("동일한 친구 관계가 중복해서 주어지지 않아야 합니다.")
            }
        }
    }

    @Nested
    inner class `validateVisitors 메소드는` {

        @Nested
        inner class `방문자가 0명 이상 10_000명 이하가 아니라면` {
            private val visitors = (0 .. 10_000).map { "id" }

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateVisitors(visitors) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }
}