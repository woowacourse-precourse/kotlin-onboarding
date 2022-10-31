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
            val cryptogram = "abbaa"
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
    }

    @Nested
    inner class Problem4Test {
        @Test
        fun case1() {
            val word = "I love you"
            val result = "R olev blf"
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
                    listOf("onepiece@email.com", "원피수"),
                    listOf("jason@email.com", "제이슨"),
                    listOf("onepisu@email.com", "원피수"),
                    listOf("mj@email.com", "엠제이"),
                    listOf("suonepi@email.com", "수원피")
            )
            val result = listOf("jason@email.com", "mj@email.com", "onepiece@email.com", "onepisu@email.com", "suonepi@email.com")
            assertThat(solution6(forms)).isEqualTo(result)
        }

        @Test
        fun case3() {
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
            val result = listOf("apple@email.com",
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
                    "zebra@email.com")
            assertThat(solution6(forms)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val forms = listOf(
                    listOf("kim@email.com", "김ㅡ이"),
                    listOf("nam@email.com", "ㅡ이야"),
                    listOf("choi@email.com", "최강"),
                    listOf("lee@email.com", "강합니다!"),
                    listOf("jun@email.com", "왜ㅇㅡ이야?")
            )
            val result = listOf("jun@email.com", "kim@email.com", "nam@email.com")
            assertThat(solution6(forms)).isEqualTo(result)
        }

        @Test
        fun case5() {
            val forms = listOf(
                    listOf("jm@email.com", "제이엠제이워니"),
                    listOf("jm@email.com", "제이슨"),
                    listOf("woniee@email.com", "워니"),
                    listOf("mj@email.com", "엠제이"),
                    listOf("nowm@email.com", "이워니")
            )
            val result = listOf(
                    "jm@email.com",
                    "mj@email.com",
                    "nowm@email.com",
                    "woniee@email.com")
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
            val friends = listOf(
                    listOf("donut", "andole"),
                    listOf("donut", "jun"),
                    listOf("donut", "mrko"),
                    listOf("shakevan", "andole"),
                    listOf("shakevan", "jun"),
                    listOf("shakevan", "mrko")
            )
            val visitors = listOf("bedi", "bedi", "donut", "bedi", "shakevan", "tom", "chris", "kevin")
            val result = listOf("andole", "jun", "bedi", "chris", "kevin")
            assertThat(solution7(user, friends, visitors)).isEqualTo(result)
        }
    }
}
