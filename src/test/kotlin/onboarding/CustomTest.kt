package onboarding

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@Nested
class Problem7CustomTest {
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