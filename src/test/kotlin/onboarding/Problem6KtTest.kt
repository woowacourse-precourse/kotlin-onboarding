package onboarding

import camp.nextstep.edu.missionutils.Randoms
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.Duration

internal class `문제 6번의` {

    @Nested
    inner class `validateEmail 메소드는` {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `이메일 형식에 맞지 않는 문자열을 입력하면` {
            private fun emails() = listOf(
                Arguments.of("qwe123456naver.com"),
                Arguments.of("qwe123456@navercom"),
                Arguments.of("qwe123456navercom"),
            )

            @ParameterizedTest
            @MethodSource("emails")
            fun `예외를 던진다`(email: String) {
                assertThatThrownBy { validateEmail(email) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessage("이메일 형식에 맞지 않습니다.")
            }
        }

        @Nested
        inner class `이메일의 도메인이 email닷컴이 아니라면` {
            private val email = "qwe123465@naver.com"

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateEmail(email) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessage("이메일의 도메인은 email.com이어야 합니다.")
            }
        }

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `이메일의 길이가 11자 이상 20자 미만이 아니라면` {
            private val email = "qwe1234567@email.com"

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateEmail(email) }.isInstanceOf(IllegalArgumentException::class.java)
                    .hasMessage("이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다.")
            }
        }
    }

    @Nested
    inner class `validateNickname 메소드는` {

        @Nested
        inner class `한글이 아닌 문자열이 주어지면` {
            private val nickname = "qwe"

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateNickname(nickname) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `길이가 1자 이상 20자 미만이 아닌 한글 문자열이 주어지면` {
            private val nickname = "쌟꿇뺛툝쿇쩂츓쏅쌟꿇뺛툝쿇쩂츓쏅쌟꿇뺛툝쿇쩂츓"

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateNickname(nickname) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }

    @Nested
    inner class `validateForms 메소드는` {

        @Nested
        inner class `신청한 사람이 10_000명 초과라면` {
            private val forms = (1..10001).map { listOf("email$it@email.com", "닉네임") }

            @Test
            fun `예외를 던진다`() {
                assertThatThrownBy { validateForms(forms) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }
    }

    @Nested
    inner class `areSimilar 메소드는` {

        @Nested
        inner class `만약 한 닉네임이 다른 닉네임의 연속되지 않는 같은 글자들을 포함한다면` {
            private val nickname1 = "가나다라마바사아자차카타파하"

            @Test
            fun `false를 반환한다`() {
                val nickname2 = nickname1.reversed()

                val result = areSimilar(nickname1, nickname2)

                assertThat(result).isFalse
            }
        }

        @Nested
        inner class `만약 한 닉네임이 다른 닉네임의 연속된 두 글자를 포함한다면` {
            private val nickname1 = "가나다라마바사아자차가타파하"
            private val nickname2 = "아자거너더러머버서어처처커터퍼허"

            @Test
            fun `true를 반환한다`() {
                val result = areSimilar(nickname1, nickname2)

                assertThat(result).isTrue
            }
        }
    }

    @Nested
    inner class `haveSimilarNicknames 메소드는` {

        @Nested
        inner class `두 신청서가 같은 이메일을 가졌다면` {
            private val form1 = listOf("qwe123456@email.com", "가나다")
            private val form2 = listOf("qwe123456@email.com", "가나다")

            @Test
            fun `false를 반환한다`() {
                val result = haveSimilarNicknames(form1, form2)

                assertThat(result).isFalse
            }
        }

        @Nested
        inner class `두 신청서가 다른 이메일을 가졌고 비슷한 닉네임을 가졌다면` {
            private val form1 = listOf("qwe123456@email.com", "가나다")
            private val form2 = listOf("qwe123457@email.com", "나다라")

            @Test
            fun `true를 반환한다`() {
                val result = haveSimilarNicknames(form1, form2)

                assertThat(result).isTrue
            }
        }
    }

    @Nested
    inner class `solution6 메소드는` {

        @Nested
        inner class `여러 신청서를 입력하면` {
            private val characters = "가나다라마바사아자차카타파하가나"
            private val forms = (0..14).map { listOf("qwe$it@email.com", characters.substring(it, it + 2)) }

            @Test
            fun `다른 신청서와 비슷한 닉네임을 가진 신청서들의 이메일 리스트를 반환한다`() {
                val result = solution6(forms)

                assertThat(result).containsExactly("qwe0@email.com", "qwe14@email.com")
            }
        }

        @Nested
        inner class `비슷한 닉네임을 가진 신청서들이 주어지면` {
            private val forms = (9 downTo 1).map { listOf("qwe$it@email.com", "닉네임") }

            @Test
            fun `이메일 리스트를 오름차순으로 반환한다`() {
                val result = solution6(forms)

                assertThat(result).isEqualTo((1..9).map { "qwe$it@email.com" })
            }
        }
    }
}