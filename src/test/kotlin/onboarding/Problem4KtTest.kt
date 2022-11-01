package onboarding

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.IllegalArgumentException

internal class `문제 4번의` {

    @Nested
    inner class `validateWord 메소드는` {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `단어의 길이가 1 이상 1000 이하가 아니라면` {
            private fun words() = listOf(
                Arguments.of(""),
                Arguments.of("a".repeat(1001))
            )

            @ParameterizedTest
            @MethodSource("words")
            fun `예외를 던진다`(word: String) {
                Assertions.assertThatThrownBy { validateWord(word) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }

    @Nested
    inner class `reversedAlphabet 메소드는` {

        @Nested
        inner class `소문자 알파벳이 주어지면` {
            private val alphabet = 'c'

            @Test
            fun `순서가 반대인 소문자 알페벳을 반환한다`() {
                val reversedAlphabet = reversedAlphabet(alphabet)

                assertThat(reversedAlphabet).isEqualTo('x')
            }
        }

        @Nested
        inner class `대문자 알파벳이 주어지면` {
            private val alphabet = 'G'

            @Test
            fun `순서가 반대인 대문자 알파벳을 반환한다`() {
                val reversedAlphabet = reversedAlphabet(alphabet)

                assertThat(reversedAlphabet).isEqualTo('T')
            }
        }

        @Nested
        inner class `알파벳이 아닌 문자가 주어지면` {
            private val char = ' '

            @Test
            fun `문자 그대로 반환한다`() {
                val reversedAlphabet = reversedAlphabet(char)

                assertThat(reversedAlphabet).isEqualTo(char)
            }
        }
    }

    @Nested
    inner class `solution4 메소드는` {

        @Nested
        inner class `문자열이 주어지면` {
            private val word = "I love you"

            @Test
            fun `모든 알파벳의 순서가 반대인 알파벳으로 변환한 문자열을 반환한다`() {
                val reversedWord = solution4(word)

                assertThat(reversedWord).isEqualTo("R olev blf")
            }
        }
    }

}