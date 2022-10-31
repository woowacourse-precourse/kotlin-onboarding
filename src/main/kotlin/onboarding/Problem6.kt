package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()
    forms.forEachIndexed { applyIndex, apply ->
        for (i in 0..apply[1].length - 2) {
            result.addAll(forms.filterIndexed { index, it ->
                applyIndex != index && it[1].contains(apply[1].substring(i, i+2))
            }.map { it[0] })
        }
    }
    return result.map { it }.sorted()
}