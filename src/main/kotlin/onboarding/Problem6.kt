package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val resultEmail = checkOverlap(forms)
    val result = resultEmail.toList()
    return result.sorted()
}

fun checkOverlap(forms: List<List<String>>): MutableSet<String> {
    val resultEmail: MutableSet<String> = mutableSetOf()
    for (nickname in forms) {
        for (i in 0 until nickname[1].length - 1) {
            val filtered = forms.filter { it[1].contains("${nickname[1][i]}" + "${nickname[1][i + 1]}") }
            if (filtered.size > 1) {
                for (element in filtered) {
                    resultEmail.add(element[0])
                }
            }
        }
    }
    return resultEmail
}