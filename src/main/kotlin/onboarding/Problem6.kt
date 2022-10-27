package onboarding

/**
 * @author onseok
 */
fun solution6(forms: List<List<String>>): List<String> {
    val ans = mutableSetOf<String>()
    for (i in 0 until forms.size - 1) {
        for (j in i + 1 until forms.size) {
            if (forms[i].last().isDuplicatedWith(forms[j].last())) {
                ans.add(forms[i].first())
            }
        }
    }
    return ans.toList().sorted()
}

fun String.isDuplicatedWith(other: String): Boolean {
    if (this.length == 1 ||
        other.length == 1
    ) return false
    val candidate = mutableSetOf<String>()
    for (i in 0 until other.length - 1) {
        for (j in 1 until other.length - i) {
            candidate.add(other.substring(i, i + j))
        }
    }
    candidate.forEach {
        if (this.contains(it)) {
            return true
        }
    }
    return false
}