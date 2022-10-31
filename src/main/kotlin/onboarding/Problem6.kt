package onboarding

import problem2.StringLengthVerifier
import problem6.*

private val orderedForms = mutableListOf<List<String>>()

private fun validateList(forms: List<List<String>>) {
    val formsSizeValidator = InputValidator(
        listOf(
            ListSizeVerifier(1, 10000)
        )
    )
    formsSizeValidator.validate(forms)

    val formSizeValidator = InputValidator(
        listOf(
            ListSizeVerifier(2, 2)
        )
    )
    for(form in forms) {
        formSizeValidator.validate(form)
    }
}

private fun createOrderedForms(forms: List<List<String>>) {
    for(form in forms) {
        val listSorter = ListSorter(form)
        val orderedForm = listSorter.sortByEmailNicknameOrder()
        orderedForms.add(orderedForm)
    }
}

private fun validateCrewInfo() {
    val emailValidator = InputValidator(
        listOf(
            EmailFormatVerifier(),
            StringLengthVerifier(11, 19),
            EmailDomainVerifier("email.com")
        )
    )
    val nicknameValidator = InputValidator(
        listOf(
            KoreanVerifier(),
            StringLengthVerifier(1, 19)
        )
    )

    for((email, nickname) in orderedForms) {
        emailValidator.validate(email)
        nicknameValidator.validate(nickname)
    }
}

fun solution6(forms: List<List<String>>): List<String> {
    validateList(forms)

    createOrderedForms(forms)

    validateCrewInfo()

    val nicknameManager = NicknameManager(orderedForms)
    nicknameManager.apply()

    return listOf()
}
