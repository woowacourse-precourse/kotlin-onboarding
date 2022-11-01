package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result: HashSet<String> = hashSetOf()
    for (i in forms.indices) {
        val targetName = forms[i][1]
        for (j in 0..targetName.length - 2) {
            val targetString = targetName.substring(j, j + 2)
            for (k in i+1 until forms.size) {
                if (forms[k][1].contains(targetString)) {
                    result.add(forms[i][0])
                    result.add(forms[k][0])
                }
            }
        }
    }
    return result.toList().sorted()
}