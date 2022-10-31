package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val emailDictionary = mutableMapOf<String, MutableSet<String>>()
    makeEmailDictionary(emailDictionary, forms)
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
