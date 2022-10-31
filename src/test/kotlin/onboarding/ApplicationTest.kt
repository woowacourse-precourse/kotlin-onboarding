package onboarding

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ApplicationTest {
    @Nested
    inner class Problem1Test {
        @Test
        fun case1() {
            val pobi = listOf(97, 98)
            val crong = listOf(197, 198)
            val result = 0
            assertThat(solution1(pobi, crong)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val pobi = listOf(131, 132)
            val crong = listOf(211, 212)
            val result = 1
            assertThat(solution1(pobi, crong)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val pobi = listOf(99, 102)
            val crong = listOf(211, 212)
            val result = -1
            assertThat(solution1(pobi, crong)).isEqualTo(result)
        }
    }

    @Nested
    inner class Problem2Test {
        @Test
        fun case1() {
            val cryptogram = "browoanoommnaon"
            val result = "brown"
            assertThat(solution2(cryptogram)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val cryptogram = "zyelleyz"
            val result = ""
            assertThat(solution2(cryptogram)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val cryptogram = "zyellleyz"
            val result = ""
            assertThat(solution2(cryptogram)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val cryptogram = "zyalllelyz"
            val result = "zyaelyz"
            assertThat(solution2(cryptogram)).isEqualTo(result)
        }

        @Test
        fun case5() {
            val cryptogram = "aabba"
            val result = "a"
            assertThat(solution2(cryptogram)).isEqualTo(result)
        }
    }

    @Nested
    inner class Problem3Test {
        @Test
        fun case1() {
            val number = 13
            val result = 4
            assertThat(solution3(number)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val number = 33
            val result = 14
            assertThat(solution3(number)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val number = 333
            val result = 228
            assertThat(solution3(number)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val number = 2
            val result = 0
            assertThat(solution3(number)).isEqualTo(result)
        }
    }

    @Nested
    inner class Problem4Test {
        @Test
        fun case1() {
            val word = "I love you"
            val result = "R olev blf"
            assertThat(solution4(word)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val word = "Hello Everyone!"
            val result = "Svool Veviblmv!"
            assertThat(solution4(word)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val word = "Svool, Dliow! 123"
            val result = "Hello, World! 123"
            assertThat(solution4(word)).isEqualTo(result)
        }
    }

    @Nested
    inner class Problem5Test {
        @Test
        fun case1() {
            val money = 50_237
            val result = listOf(1, 0, 0, 0, 0, 2, 0, 3, 7)
            assertThat(solution5(money)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val money = 15_000
            val result = listOf(0, 1, 1, 0, 0, 0, 0, 0, 0)
            assertThat(solution5(money)).isEqualTo(result)
        }
    }

    @Nested
    inner class Problem6Test {
        @Test
        fun case1() {
            val forms = listOf(
                listOf("jm@email.com", "제이엠"),
                listOf("jason@email.com", "제이슨"),
                listOf("woniee@email.com", "워니"),
                listOf("mj@email.com", "엠제이"),
                listOf("nowm@email.com", "이제엠")
            )
            val result = listOf("jason@email.com", "jm@email.com", "mj@email.com")
            assertThat(solution6(forms)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val forms = listOf(
                listOf("jm@email.com", "제이엠"),
                listOf("jason@email.com", "제이슨"),
                listOf("woniee@email.com", "워니"),
                listOf("mj@email.com", "엠제이"),
                listOf("nowm@email.com", "이제엠"),
                listOf("jasp@email.com", "박이김"),
                listOf("jp@email.com", "김이박"),
                listOf("qpw@email.com", "김이순"),
                listOf("teemo@email.com", "티모"),
                listOf("banana@email.com", "대위티모"),
                listOf("secondJm@email.com", "제이엠"),
                listOf("apple@email.com", "땷횱봵"),
                listOf("stran@email.com", "횱봵으"),
                listOf("zebra@email.com", "두글자이상의문자가연속적으로이제맞티모")
            )
            val result = listOf(
                "apple@email.com",
                "banana@email.com",
                "jason@email.com",
                "jm@email.com",
                "jp@email.com",
                "mj@email.com",
                "nowm@email.com",
                "qpw@email.com",
                "secondJm@email.com",
                "stran@email.com",
                "teemo@email.com",
                "zebra@email.com",
            )
            assertThat(solution6(forms)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val forms: List<List<String>> = listOf(
                listOf("kim@email.com", "김ㅡ이"),
                listOf("nam@email.com", "ㅡ이야"),
                listOf("choi@email.com", "최강"),
                listOf("lee@email.com", "강합니다"),
                listOf("jun@email.com", "왜ㅇㅡ이야")
            )
            val result: List<String> = listOf("jun@email.com", "kim@email.com", "nam@email.com")
            assertThat(solution6(forms)).isEqualTo(result)
        }
    }

    @Nested
    inner class Problem7Test {
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
            assertThat(solution7(user, friends, visitors)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val user = "mrko"
            val friends: List<List<String>> = listOf(
                listOf("mrko", "jun"),
                listOf("donut", "jun"),
                listOf("donut", "mrko"),
                listOf("shakevan", "andole"),
                listOf("shakevan", "jun"),
                listOf("shakevan", "mrko")
            )
            val visitors: List<String> = listOf("bedi", "bedi", "donut", "bedi", "shakevan")
            val result: List<String> = listOf("andole", "bedi")
            assertThat(solution7(user, friends, visitors)).isEqualTo(result)
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
            assertThat(solution7(user, friends, visitors)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val user = "mrko"
            val friends: List<List<String>> = listOf(
                listOf("mrko", "jun"),
                listOf("bedi", "jun"),
                listOf("bedi", "donut"),
                listOf("donut", "jun"),
                listOf("donut", "mrko"),
                listOf("shakevan", "andole"),
                listOf("jun", "andole"),
                listOf("shakevan", "jun"),
                listOf("shakevan", "mrko")
            )
            val visitors: List<String> = listOf("donut", "shakevan")
            val result: List<String> = listOf("andole", "bedi")
            assertThat(solution7(user, friends, visitors)).isEqualTo(result)
        }

        @Test
        fun case5() {
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
            assertThat(solution7(user, friends, visitors)).isEqualTo(result)
        }
    }
}
