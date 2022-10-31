package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val charToNextCharsAndEmail = HashMap<Char, MutableMap<Char, String>>()

    val emails = mutableSetOf<String>()
    for (user in forms) {
        val nickname = user[1]
        val email = user[0]
        for (i in (0 until nickname.length - 1)) {
            val c = nickname[i]
            val nextC = nickname[i + 1]
            val map = charToNextCharsAndEmail.getOrPut(c, ::HashMap)

            if (nextC in map) {
                val prevEmail = map[nextC]!!
                emails.add(email)
                emails.add(prevEmail)
            }

            map[nextC] = email
        }
    }

    return emails.toList().sortedBy { it.substringBefore('@') }
}
