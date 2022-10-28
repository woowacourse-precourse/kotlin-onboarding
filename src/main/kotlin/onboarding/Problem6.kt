package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result: HashSet<String> = hashSetOf()
    for (i in forms.indices) {
        val name = forms[i][1]
        for (j in 0..name.length - 2) {
            val tmp = name.substring(j, j + 2)
            for (k in forms.indices) {
                if (forms[k][1].contains(tmp)) {
                    if (forms[k][0] != forms[i][0]) {
                        result.add(forms[k][0])
                    }
                }
            }
        }
    }
    return result.toList().sorted()
}