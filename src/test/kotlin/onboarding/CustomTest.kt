package onboarding

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@Nested
class CustomTest {
    @Nested
    inner class Problem2CustomTest {
        @Test
        fun case3() {
            val cryptogram = "zyalllelyz"
            val result = "zyaelyz"
            Assertions.assertThat(solution2(cryptogram)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val cryptogram = "aabba"
            val result = "a"
            Assertions.assertThat(solution2(cryptogram)).isEqualTo(result)
        }

        @Test
        fun case5() {
            val cryptogram = "aa"
            val result = ""
            Assertions.assertThat(solution2(cryptogram)).isEqualTo(result)
        }
    }

    @Nested
    inner class Problem3CustomTest {
        @Test
        fun case3() {
            val number = 333
            val result = 228
            Assertions.assertThat(solution3(number)).isEqualTo(result)
        }

    }

    @Nested
    inner class Problem4CustomTest {
        @Test
        fun case2() {
            val word = "Hello  Everyone!"
            val result = "Svool  Veviblmv!"
            Assertions.assertThat(solution4(word)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val word = "abcdefghijklmnopqrstuvwxyz"
            val result = "zyxwvutsrqponmlkjihgfedcba"
            Assertions.assertThat(solution4(word)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val word = "abcdefghijklmnopqrstuvwxyz !@#!#  "
            val result = "zyxwvutsrqponmlkjihgfedcba !@#!#  "
            Assertions.assertThat(solution4(word)).isEqualTo(result)
        }

        @Test
        fun case5() {
            val word = "Svool, Dliow! 123"
            val result = "Hello, World! 123"
            Assertions.assertThat(solution4(word)).isEqualTo(result)
        }
    }

    @Nested
    inner class Problem6CustomTest {
        @Test
        fun case4() {
            val forms: List<List<String>> = listOf(
                listOf("kim@email.com", "김이"),
                listOf("nam@email.com", "이야"),
                listOf("choi@email.com", "최강"),
                listOf("lee@email.com", "강합니다"),
                listOf("jun@email.com", "왜이야왜이야")
            )
            val result: List<String> = listOf("jun@email.com", "nam@email.com")
            Assertions.assertThat(solution6(forms)).isEqualTo(result)
        }
    }

    @Nested
    inner class Problem7CustomTest {
        @Test
        fun case1() {
            val user = "mrko"
            val friends = listOf(
                listOf("donut", "andole"),
                listOf("donut", "jun"),
                listOf("donut", "mrko"),
                listOf("shakevan", "andole"),
                listOf("shakevan", "jun"),
                listOf("shakevan", "mrko")
            )
            val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
            val result = listOf("andole", "jun", "bedi")
            Assertions.assertThat(solution7(user, friends, visitors)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val user = "mrko"
            val friends: List<List<String>> = listOf(
                listOf("mrko", "jun"),
                listOf("donut", "jun"),
                listOf("donut", "mrko"),
                listOf("shakevan", "andole"),
                listOf("jun", "andole"),
                listOf("shakevan", "jun"),
                listOf("shakevan", "mrko")
            )
            val visitors: List<String> = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
            val result: List<String> = listOf("andole", "bedi")
            Assertions.assertThat(solution7(user, friends, visitors)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val user = "andole"
            val friends: List<List<String>> = listOf(
                listOf("andole", "jun"),
                listOf("donut", "jun"),
                listOf("donut", "shakevan"),
                listOf("shakevan", "andole"),
                listOf("shakevan", "jun"),
                listOf("shakevan", "bedi"),
                listOf("anne", "jun"),
            )
            val visitors: List<String> = listOf("donut", "mrko", "peter", "sam")
            val result: List<String> = listOf("donut", "anne", "bedi", "mrko", "peter")
            Assertions.assertThat(solution7(user, friends, visitors)).isEqualTo(result)
        }

        @Test
        fun case7() {
            val user = "hello"
            val friends: List<List<String>> = listOf(
                listOf("andole", "jun"),
                listOf("andole", "bedi"),
                listOf("jun", "shakevan"),
                listOf("jun", "kane"),
                listOf("jun", "sam"),
                listOf("bedi", "shakevan"),
                listOf("bedi", "anne"),
                listOf("bedi", "sam"),
                listOf("anne", "mrko")
            )
            val visitors: List<String> = listOf("donut", "anne", "mrko", "mrko", "sam")
            val result: List<String> = listOf("mrko", "anne", "donut", "sam")
            Assertions.assertThat(solution7(user, friends, visitors)).isEqualTo(result)
        }
    }
}