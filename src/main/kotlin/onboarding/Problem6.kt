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

                if (checkRepeat(nick, nowNick)) {
                    ans.add(email)
                    ans.add(nowEmail)
                }
            }
        }
    }
    return ans.toList().sorted()
}

fun checkRepeat(rootNick: String, nowNick: String): Boolean {
    for (i in 0 until nowNick.length - 1) {
        if (rootNick.contains(nowNick.substring(i, i + 2)))
            return true
    }
    return false
}
