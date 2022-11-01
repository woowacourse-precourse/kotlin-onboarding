package onboarding

import java.lang.IllegalArgumentException

fun solution6(forms: List<List<String>>): List<String> {
    validateForms(forms)

    return forms.filter { form -> forms.any { haveSimilarNicknames(it, form) } }.map { it[0] }.toSet().sorted()
}

fun haveSimilarNicknames(form1: List<String>, form2: List<String>): Boolean =
    if (form1[0] == form2[0]) false else areSimilar(form1[1], form2[1])

fun areSimilar(nickname1: String, nickname2: String): Boolean =
    (0 until nickname1.length - 1).any { nickname2.contains(nickname1.substring(it, it + 2)) }

fun validateForms(forms: List<List<String>>) {
    if (forms.size !in 0..10_000)
        throw IllegalArgumentException("신청서는 10,000개 이하여야 합니다.")
    forms.forEach { validateForm(it) }
}

fun validateForm(form: List<String>) {
    val (email, nickname) = form
    validateEmail(email)
    validateNickname(nickname)
}

fun validateEmail(email: String) {
    if (!email.matches(Regex("\\w+@\\w+\\.\\w+")))
        throw IllegalArgumentException("이메일 형식에 맞지 않습니다.")
    if (!email.matches(Regex("\\w+@email\\.com")))
        throw IllegalArgumentException("이메일의 도메인은 email.com이어야 합니다.")
    if (email.length !in 11 until 20)
        throw IllegalArgumentException("이메일의 전체 길이는 11자 이상 20자 미만이어야 합니다.")
}

fun validateNickname(nickname: String) {
    if (!nickname.matches(Regex("[가-힣]{1,19}")))
        throw IllegalArgumentException("닉네임은 한글만 가능하고 1자 이상 20자 미만이어야 합니다. $nickname")
}
