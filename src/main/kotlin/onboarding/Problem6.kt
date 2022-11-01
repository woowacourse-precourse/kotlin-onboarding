package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()

    forms.forEachIndexed { index, info ->
        val address = info[0]
        val name = info[1]

        if (name.length == 1) return@forEachIndexed

        for (startChar in name.indices - 2) {
            val token = if (name.length != 2) name.substring(startChar, startChar + 2) else name

            var isDuplicated = false
            for (i in index + 1 until forms.size) {
                if (i < forms.size) {
                    if (forms[i][1].contains(token)) {
                        isDuplicated = true
                        result.add(forms[i][0])
                        break
                    }
                }
            }

            if (isDuplicated) result.add(address)
        }
    }

    return result.sorted()
}
