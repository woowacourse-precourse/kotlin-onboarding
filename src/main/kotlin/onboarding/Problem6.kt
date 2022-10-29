package onboarding

import java.util.regex.Pattern


const val DOMAIN = "@email.com"

fun emailLength(email: String): Boolean {
    return email.length in 11 until 20
}

fun nickNameLength(nickname: String): Boolean {
    return nickname.length in 1 until 20
}

fun correctLength(email: String, nickname: String): Boolean {
    return emailLength(email) && nickNameLength(nickname)
}

fun correctDomain(email: String): Boolean {
    return email.contains(DOMAIN)
}

fun correctNickName(nickname: String): Boolean {
    val pattern = Pattern.compile("^[ㄱ-ㅣ가-힣]+$")
    return pattern.matcher(nickname).matches()
}

fun correctException(email: String, nickname: String): Boolean {
    return correctDomain(email) && correctLength(email, nickname) && correctNickName(nickname)
}

fun createNickNames(forms: List<List<String>>): Map<String, Set<String>> {
    val nicknames = mutableMapOf<String, MutableSet<String>>()
    for ((email, nickname) in forms) {
        if (!correctException(email, nickname)) {
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
    return compareNicknames(createNickNames(forms))
}