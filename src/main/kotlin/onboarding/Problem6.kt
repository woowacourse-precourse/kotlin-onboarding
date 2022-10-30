package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

fun isWrongEmail(email: String): Boolean {
    val (_, domain) = email.split("@")

    return when {
        !EMAIL_PATTERN.toRegex().matches(email) -> true
        email.length !in EMAIL_MIN_LEN..EMAIL_MAX_LEN -> true
        domain != EMAIL_DOMAIN -> true
        else -> false
    }
}

const val EMAIL_DOMAIN = "email.com"
const val EMAIL_PATTERN = """^[a-zA-Z]+@[a-zA-Z]+\\.[a-z]+${'$'}"""
const val EMAIL_MIN_LEN = 11
const val EMAIL_MAX_LEN = 19
const val NICKNAME_PATTERN = """/[가-힣]+$/"""
const val NICKNAME_MIN_LEN = 1
const val NICKNAME_MAX_LEN = 19