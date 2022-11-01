package onboarding

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class `문제 5번의` {

    @Nested
    inner class `validateMoney 메소드는` {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `1 이상 1_000_000 이하가 아닌 자연수가 주어지면` {
            private fun moneys() = listOf(
                Arguments.of(0),
                Arguments.of(1_000_001)
            )

            @ParameterizedTest
            @MethodSource("moneys")
            fun `예외를 던진다`(money: Int) {
                assertThatThrownBy { validateMoney(money) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }

    @Nested
    inner class `solution5 메소드는` {

        @Nested
        inner class `인출할 돈의 액수가 주어지면` {
            private val money = 50_000

            @Test
            fun `화폐의 개수가 가장 작도록 인출하는 방법을 반환한다`() {
                val result = solution5(money)

                assertThat(result).isEqualTo(listOf(1, 0, 0, 0, 0, 0, 0, 0, 0))
            }
        }
    }

}