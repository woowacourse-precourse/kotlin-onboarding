package onboarding

private val EMAIL_FORMAT = "^[\\w._-]{1,9}@email.com\$".toRegex()
private val NICKNAME_FORMAT = "^[ㄱ-힣]{1,19}\$".toRegex()

fun solution6(forms: List<List<String>>): List<String> {
    return forms
        .filter { isValidEmail(it[0]) && isValidNickName(it[1]) }
        .let { it.filter { user -> checkSimilarNickname(makeNickNameToPiece(forms), user[1]) } }
        .map { it[0] }
        .toSortedSet()
        .toList()
}

private fun isValidEmail(email: String) = EMAIL_FORMAT.matches(email)

private fun isValidNickName(nickname: String) = NICKNAME_FORMAT.matches(nickname)

private fun makeNickNameToPiece(forms: List<List<String>>): HashMap<String, Int> {
    val allNickNamePiece = hashMapOf<String, Int>()

    for (form in forms) {
        val nickName = form[1]

        for (i in 0 until nickName.lastIndex) {
            for (j in (i + 1)..nickName.lastIndex) {
                val nickNamePiece = nickName.slice(i..j)
                allNickNamePiece[nickNamePiece] = allNickNamePiece.getOrDefault(nickNamePiece, 0) + 1
            }
        }
    }
    return allNickNamePiece
}

private fun checkSimilarNickname(allNickNamePiece: HashMap<String, Int>, nickName: String): Boolean {
    for (i in 0 until nickName.lastIndex) {
        for (j in (i + 1)..nickName.lastIndex) {
            val nickNamePiece = nickName.slice(i..j)
            if (allNickNamePiece.getOrDefault(nickNamePiece, 0) > 1) {
                return true
            }
        }
    }
    return false
}
