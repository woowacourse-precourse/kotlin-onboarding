package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()

    forms.forEachIndexed { i, value ->
        val email = value[0]
        val name = value[1]

        for (j in 0..name.length - 3) {
            val duplicateString = if (name.length != 2) {
                name.substring(j, j + 2)
            } else {
                name
            }

            for (k in (i + 1) until forms.size) {
                if (k < forms.size) {
                    if (forms[k][1].contains(duplicateString)) {
                        result.add(forms[k][0])
                        result.add(email)
                    }
                }
            }
        }
    }

    return result.sorted()
}
