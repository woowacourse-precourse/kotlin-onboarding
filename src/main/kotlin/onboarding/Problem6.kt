package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()

    forms.forEachIndexed { _, value ->
        val email = value[0]
        val name = value[1]

    }

    return result.sorted()
}
