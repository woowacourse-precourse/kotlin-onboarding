package onboarding

import org.assertj.core.api.Assertions
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
    }

    // 직접 추가
    // Prob 4
    @Nested
    inner class ChangeCharByFrogTest {
        @Test
        fun case1() {
            val word = 'A'
            val result = 'Z'
            assertThat(changeCharByFrog(word)).isEqualTo(result)
        }
        @Test
        fun case2() {
            val word = 'g'
            val result = 't'
            assertThat(changeCharByFrog(word)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val word = 'Q'
            val result = 'J'
            assertThat(changeCharByFrog(word)).isEqualTo(result)
        }
    }

    // Prob 6
    @Nested
    inner class GetSubWordsOfNameTest {
        @Test
        fun case1() {
            val name = "제이엠"
            val result = hashSetOf("제이", "이엠")
            assertThat(getSubWordsOfName(name)).isEqualTo(result)
        }
        @Test
        fun case2() {
            val name = "아이엠쑤"
            val result = hashSetOf("아이", "이엠", "엠쑤")
            assertThat(getSubWordsOfName(name)).isEqualTo(result)
        }
    }

    @Nested
    inner class GetSubWordsListTest {
        @Test
        fun case1() {
            val forms = listOf(
                listOf("jm@email.com", "제이엠"),
                listOf("jason@email.com", "제이슨")
            )
            val result = arrayOf(
                hashSetOf("제이", "이엠"),
                hashSetOf("제이", "이슨")
            )
            assertThat(getSubWordsList(forms)).isEqualTo(result)
        }
    }

    @Nested
    inner class IsDuplicatedNameTest {
        @Test
        fun case1() {
            val index = 0
            val list = arrayOf(
                hashSetOf("제이", "이엠"),
                hashSetOf("제이", "이슨")
            )
            val result = true
            assertThat(isDuplicatedName(index, list)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val index = 0
            val list = arrayOf(
                hashSetOf("제이", "이엠"),
                hashSetOf("우테", "테코")
            )
            val result = false
            assertThat(isDuplicatedName(index, list)).isEqualTo(result)
        }
    }

    @Nested
    inner class GetMyFriendsListTest {
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
            val result = hashSetOf("donut", "shakevan")
            assertThat(getMyFriendsList(user, friends)).isEqualTo(result)
        }
    }
}
