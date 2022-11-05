package onboarding

import java.util.regex.Pattern


const val DOMAIN = "@email.com"

fun emailLength(email: String): Boolean = email.length in 11 until 20

fun nicknameLength(nickname: String): Boolean = nickname.length in 1 until 20

fun isLength(email: String, nickname: String): Boolean = emailLength(email) && nicknameLength(nickname)

fun isDomain(email: String): Boolean = email.contains(DOMAIN)

fun isNickname(nickname: String): Boolean {
    val pattern = Pattern.compile("^[ㄱ-ㅣ가-힣]+$")
    return pattern.matcher(nickname).matches()
}

fun isException(email: String, nickname: String): Boolean = isDomain(email) && isLength(email, nickname) && isNickname(nickname)


fun createNicknames(forms: List<List<String>>): Map<String, Set<String>> {
    val nicknames = mutableMapOf<String, MutableSet<String>>()
    for ((email, nickname) in forms) {
        if (!isException(email, nickname)) {
            continue
        }
        for (i in 0..nickname.length - 2) {
            for (j in 2 + i..nickname.length) {
                val str = nickname.substring(i, j)
                if (nicknames[str] == null)
                    nicknames[str] = mutableSetOf()
                nicknames[str]?.add(email)
            }
        }
    }
    return nicknames
}

fun compareNicknames(nicknames: Map<String, Set<String>>): List<String> {
    val result: MutableList<String> = mutableListOf()
    for (nickname in nicknames) {
        if (nickname.value.size > 2)
            for (value in nickname.value) {
                result.add(value)
            }
    }
    return result.sorted()
}

fun solution6(forms: List<List<String>>): List<String> {
    return compareNicknames(createNicknames(forms))
}