package onboarding

fun solution6(forms: List<List<String>>): List<String> {

    val ans = mutableSetOf<String>()

    for (i in forms.indices) {
        val email = forms[i][0]
        val nick = forms[i][1]

        if (nick.length >= 2) {
            for (j in (i + 1) until forms.size) {
                val nowEmail = forms[j][0]
                val nowNick = forms[j][1]


            }
        }
    }
    return ans.toList().sorted()
}

