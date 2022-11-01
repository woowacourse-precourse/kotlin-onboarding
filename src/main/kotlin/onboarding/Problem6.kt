package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val emailDictionary = mutableMapOf<String, MutableSet<String>>()
    makeEmailDictionary(emailDictionary, forms)

    val resultSet = gatherOverlappedEmailSet(emailDictionary)
    return resultSet.sorted().toList()
}

private fun makeEmailDictionary(emailDictionary: MutableMap<String, MutableSet<String>>, forms: List<List<String>>) {
    for (i in forms.indices) {
        val nickName = forms[i][1]
        for (idx in 0..nickName.length - 2) {
            val part = nickName.slice(IntRange(idx, idx + 1))
            emailDictionary[part]?.add(forms[i][0]) ?: emailDictionary.put(part, mutableSetOf(forms[i][0]))
        }
    }
}

private fun gatherOverlappedEmailSet(emailDictionary: MutableMap<String, MutableSet<String>>): Set<String> {
    val gatheredEmailSet = mutableSetOf<String>()
    emailDictionary.values.groupBy { emailSet -> if (emailSet.size >= 2) gatheredEmailSet.addAll(emailSet) }
    return gatheredEmailSet
}
