package onboarding

fun main(args: Array<String>) {
    val forms = listOf(
        listOf("jm@email.com", "제이엠"),
        listOf("jason@email.com", "제이슨"),
        listOf("woniee@email.com", "워니"),
        listOf("mj@email.com", "엠제이"),
        listOf("nowm@email.com", "이제엠"),
        listOf("jm@email.com", "dhfㄱ"),
        listOf("jmemail.com", "제이"),
    )
    println(solution6(forms))
}

fun solution6(forms: List<List<String>>): List<String> {
    val rightForms = forms.filter { (email, nickname) ->
        isRightEmail(email = email) && isRightNickname(nickname = nickname)
    }

    return checkDuplication(forms = rightForms)
}

fun checkDuplication(forms: List<List<String>>): List<String> {
    val resultEmails = mutableListOf<String>()

    return resultEmails.toList()
}

fun isRightEmail(email: String): Boolean {
    if (EMAIL_PATTERN.toRegex().matches(email)) {
        val emailStruct = email.split("@")

        if (email.length in EMAIL_MIN_LEN until EMAIL_MAX_LEN && emailStruct[1] == EMAIL_DOMAIN) {
            return true
        }
    }
    return false
}

fun isRightNickname(nickname: String): Boolean =
    nickname.length in NICKNAME_MIN_LEN until NICKNAME_MAX_LEN && NICKNAME_PATTERN.toRegex().matches(nickname)

const val EMAIL_DOMAIN = "email.com"
const val EMAIL_PATTERN = """^[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]+$"""
const val EMAIL_MIN_LEN = 11
const val EMAIL_MAX_LEN = 20
const val NICKNAME_PATTERN = """^[가-힣]+$"""
const val NICKNAME_MIN_LEN = 1
const val NICKNAME_MAX_LEN = 20