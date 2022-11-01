package onboarding

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class `문제 2번의` {

    @Nested
    inner class `validateCryptogram 메소드는` {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `길이가 1 이상 1000 이하가 아닌 암호문이 주어지면` {
            private fun cryptograms() = listOf(
                Arguments.of(""),
                Arguments.of("a".repeat(1001))
            )

            @ParameterizedTest
            @MethodSource("cryptograms")
            fun `예외를 던진다`(cryptogram: String) {
                assertThatThrownBy { validateCryptogram(cryptogram) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `알파벳 소문자가 아닌 문자를 포함한 암호문이 주어지면` {
            private val cryptogram = "asdfA"

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateCryptogram(cryptogram) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `알파벳이 아닌 문자를 포함한 암호문이 주어지면` {
            private val cryptogram = "asdf1asdf"

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateCryptogram(cryptogram) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }

    @Nested
    inner class `removedConsecutiveDuplicateChar 메소드는` {

        @Nested
        inner class `연속되는 중복 문자가 있는 암호문이 주어지면` {
            private val cryptogram = "aaaaaaaab"

            @Test
            fun `연속되는 중복 문자를 제거한 문자열을 반환한다`() {
                val result = removedConsecutiveDuplicateChar(cryptogram)

                assertThat(result).isEqualTo("b")
            }
        }
    }

    @Nested
    inner class `solution2 메소드는` {

        @Nested
        inner class `여러 번 연속되는 중복 문자를 제거해야 하는 암호문이 주어지면` {
            private val cryptogram = "asdfffdsa"

            @Test
            fun `연속되는 중복 문자가 없을 때까지 제거한 문자열을 반환한다`() {
                val result = solution2(cryptogram)

                assertThat(result).isEqualTo("")
            }
        }
    }
}