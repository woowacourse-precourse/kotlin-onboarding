package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result: HashSet<String> = hashSetOf()
    for (i in forms.indices) {
        val targetName = forms[i][1]
        for (j in 0..targetName.length - 2) {
            val targetString = targetName.substring(j, j + 2)
            for (k in i until forms.size) {
                val nameToCheck = forms[k][1]
                if (nameToCheck.contains(targetString)) {
                    val emailToCheck = forms[k][0]
                    result.add(emailToCheck)
                }
            }
        }
    }
    return result.toList().sorted()
}