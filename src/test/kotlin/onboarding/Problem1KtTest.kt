package onboarding

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class `문제 1번의` {

    @Nested
    inner class `validPages 메소드는` {

        @Nested
        inner class `페이지의 개수가 2개가 아니라면` {
            private val pages = listOf(123, 124, 125)

            @Test
            fun `false를 반환한다`() {
                val valid = validPages(pages)

                assertThat(valid).isFalse
            }
        }

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `첫번째 페이지가 짝수거나 두번째 페이지가 홀수이면` {
            private fun pages() = listOf(
                Arguments.of(listOf(102, 104)),
                Arguments.of(listOf(103, 105))
            )

            @ParameterizedTest
            @MethodSource("pages")
            fun `false를 반환한다`(pages: List<Int>) {
                val valid = validPages(pages)

                assertThat(valid).isFalse
            }
        }

        @Nested
        inner class `두번째 페이지가 첫번째 페이지의 바로 다음 번호가 아니면` {
            private val pages = listOf(5, 8)

            @Test
            fun `false를 반환한다`() {
                val valid = validPages(pages)

                assertThat(valid).isFalse
            }
        }

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `첫번째 페이지가 1이하거나 두번째 페이지가 400이상이면` {
            private fun pages() = listOf(
                Arguments.of(listOf(1, 2)),
                Arguments.of(listOf(399, 400))
            )

            @ParameterizedTest
            @MethodSource("pages")
            fun `false를 반환한다`(pages: List<Int>) {
                val valid = validPages(pages)

                assertThat(valid).isFalse
            }
        }

        @Nested
        inner class `올바른 페이지들이라면` {
            private val pages = listOf(3, 4)

            @Test
            fun `true를 반환한다`() {
                val valid = validPages(pages)

                assertThat(valid).isTrue
            }
        }
    }

    @Nested
    inner class `sumNumbersOfPage 메소드는` {

        @Nested
        inner class `페이지 번호가 주어지면` {
            private val page = 333

            @Test
            fun `페이지 번호의 모든 숫자들을 더한 값을 반환한다`() {
                val value = sumNumbersOfPage(page)

                assertThat(value).isEqualTo(9)
            }
        }
    }

    @Nested
    inner class `multiplyNumbersOfPage 메소드는` {

        @Nested
        inner class `페이지 번호가 주어지면` {
            private val page = 333

            @Test
            fun `페이지 번호의 모든 숫자들을 곱한 값을 반환한다`() {
                val value = multiplyNumbersOfPage(page)

                assertThat(value).isEqualTo(27)
            }
        }
    }

    @Nested
    inner class `scoreOfPage 메소드는` {

        @Nested
        inner class `페이지 번호가 주어지면` {

            private val page = 333

            @Test
            fun `각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 리턴한다`() {
                val score = scoreOfPage(page)

                assertThat(score).isEqualTo(27)
            }
        }
    }

    @Nested
    inner class `maxScoreOfPages 메소드는` {

        @Nested
        inner class `두 페이지가 주어지면` {
            private val pages = listOf(333, 334)

            @Test
            fun `더 큰 점수를 선택한다`() {
                val selectedScore = maxScoreOfPages(pages)

                assertThat(selectedScore).isEqualTo(36)
            }
        }
    }

    @Nested
    inner class `solution1 메소드는` {

        @Nested
        inner class `알맞지 않은 페이지가 주어지면` {
            private val pobi = listOf(1, 2)
            private val crong = listOf(333, 334)

            @Test
            fun `-1을 반환한다`() {
                val result = solution1(pobi, crong)

                assertThat(result).isEqualTo(-1)
            }
        }

        @Nested
        inner class `포비와 크롱의 점수가 같으면` {
            private val pobi = listOf(333, 334)
            private val crong = listOf(149, 150)

            @Test
            fun `0을 반환한다`() {
                val result = solution1(pobi, crong)

                assertThat(result).isZero
            }
        }

        @Nested
        inner class `포비의 점수가 크롱의 점수보다 높으면` {
            private val pobi = listOf(333, 334)
            private val crong = listOf(147, 148)

            @Test
            fun `1을 반환한다`() {
                val result = solution1(pobi, crong)

                assertThat(result).isOne
            }
        }

        @Nested
        inner class `포비의 점수가 크롱의 점수보다 낮으면` {
            private val pobi = listOf(147, 148)
            private val crong = listOf(333, 334)

            @Test
            fun `2를 반환한다`() {
                val result = solution1(pobi, crong)

                assertThat(result).isEqualTo(2)
            }
        }
    }
}