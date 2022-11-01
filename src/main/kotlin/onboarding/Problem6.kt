package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val emails : MutableSet<String> = mutableSetOf()
    val m : MutableMap<String, String> = mutableMapOf()

    for(i in forms.indices){
        val nicknameLength = forms[i][1].length
        (0 until nicknameLength-1)
            .map { forms[i][1].substring(it.. it +1) }
            .forEach {
                if(m.containsKey(it)){
                    emails.add(m[it]!!)
                    emails.add(forms[i][0])
                } else {
                    m[it] = forms[i][0]
                }
            }
    }
    return emails.toMutableList().sortedBy { it }
}