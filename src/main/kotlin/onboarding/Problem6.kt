package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()

    forms.forEachIndexed { _, value ->
        val email = value[0]
        val name = value[1]

        for (j in 0..name.length - 3) {
            val duplicateString = if (name.length != 2) {
                name.substring(j, j + 2)
            } else {
                name
            }
        }
    }

    return result.sorted()
}
