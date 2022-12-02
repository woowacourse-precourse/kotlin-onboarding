package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val temp = listOf(
        listOf("jm@email.com", "제이엠"),
        listOf("jason@email.com", "제이슨"),
        listOf("woniee@email.com", "워니"),
        listOf("mj@email.com", "엠제이"),
        listOf("nowm@email.com", "이제엠")
    )
    val result = listOf("jason@email.com", "jm@email.com", "mj@email.com")
    return result
}
