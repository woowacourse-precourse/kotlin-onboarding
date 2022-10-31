package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()
    for (i in forms.indices) {
        val email = forms[i][0]
        val nick = forms[i][1]
        for (j in i + 1 until forms.size) {
            val compareEmail = forms[j][0]
            val compareNick = forms[j][1]
            if (compareTo(nick, compareNick)) {
                result.add(email)
                result.add(compareEmail)
            }
        }
    }
    return result.sorted()
}

fun compareTo(nick: String, compareNick: String): Boolean {
    for (k in 0 until nick.length - 2) {
        val s = nick.substring(k, k + 2)
        if (compareNick.contains(s)) {
            return true
        }
    }
    return false
}