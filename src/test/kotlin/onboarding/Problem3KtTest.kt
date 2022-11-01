package onboarding

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.lang.IllegalArgumentException

internal class `문제 3번의` {

    @Nested
    inner class `validateNumber 메소드는` {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `1 이상 10000 이하가 아닌 숫자가 주어지면` {
            private fun numbers() = listOf(
                Arguments.of(0),
                Arguments.of(10001),
            )

            @ParameterizedTest
            @MethodSource("numbers")
            fun `예외를 던진다`(number: Int) {
                assertThatThrownBy { validateNumber(number) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }

    @Nested
    inner class `clapCount 메소드는` {

        @Nested
        inner class `숫자가 주어지면` {
            private val number = 1639

            @Test
            fun `3 또는 6 또는 9의 개수를 반환한다`() {
                val clapCount = clapCount(number)

                assertThat(clapCount).isEqualTo(3)
            }
        }
    }

    @Nested
    inner class `solution3 메소드는` {

        @Nested
        inner class `숫자가 주어지면` {
            private val number = 10

            @Test
            fun `모든 숫자들에서 3 또는 6 또는 9의 개수를 반환한다`() {
                val result = solution3(number)

                assertThat(result).isEqualTo(3)
            }
        }
    }
}