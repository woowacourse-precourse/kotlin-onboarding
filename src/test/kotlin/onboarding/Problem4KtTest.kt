package onboarding

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Problem4KtTest {

    @Test
    fun changeCharByFrog() {
        @Test
        fun case1() {
            val word = 'A'
            val result = 'Z'
            Assertions.assertThat(changeCharByFrog(word)).isEqualTo(result)
        }
        @Test
        fun case2() {
            val word = 'g'
            val result = 't'
            Assertions.assertThat(changeCharByFrog(word)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val word = 'Q'
            val result = 'J'
            Assertions.assertThat(changeCharByFrog(word)).isEqualTo(result)
        }
    }
}