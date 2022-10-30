package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val rightForms = forms.filter { (email, nickname) ->
        isRightEmail(email = email) && isRightNickname(nickname = nickname)
    }

    return checkDuplication(forms = rightForms)
}

fun checkDuplication(forms: List<List<String>>): List<String> {
    val resultEmails = mutableSetOf<String>()

    forms.forEachIndexed { fidx, (targetEmail, targetNickname) ->

        for (i in fidx + 1 until forms.size) {
            val (compareEmail, compareNickname) = forms[i]

            if (isDuplicated(targetNickname = targetNickname, compareNickname = compareNickname)) {
                resultEmails.add(targetEmail)
                resultEmails.add(compareEmail)
            }
        }
    }

    return resultEmails.toList().sorted()
}

fun isDuplicated(targetNickname: String, compareNickname: String): Boolean {
    var pattern = ""

    targetNickname.forEach { targetChar ->
        pattern += targetChar
        println("target:$targetNickname, compare:$compareNickname, pattern:$pattern")

        if (pattern !in compareNickname) {
            pattern = ""
            pattern += targetChar
        }

        if(pattern.length == 2) {
            return true
        }
    }
    return false
}

fun isRightEmail(email: String): Boolean =
    EMAIL_PATTERN.toRegex().matches(email) && email.length in EMAIL_MIN_LEN until EMAIL_MAX_LEN && EMAIL_DOMAIN in email


fun isRightNickname(nickname: String): Boolean =
    nickname.length in NICKNAME_MIN_LEN until NICKNAME_MAX_LEN && NICKNAME_PATTERN.toRegex().matches(nickname)

const val EMAIL_DOMAIN = "email.com"
const val EMAIL_PATTERN = """^[a-zA-Z]+@[a-zA-Z]+\.[a-zA-Z]+$"""
const val EMAIL_MIN_LEN = 11
const val EMAIL_MAX_LEN = 20
const val NICKNAME_PATTERN = """^[가-힣]+$"""
const val NICKNAME_MIN_LEN = 1
const val NICKNAME_MAX_LEN = 20