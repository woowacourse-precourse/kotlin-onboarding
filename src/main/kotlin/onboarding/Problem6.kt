package onboarding

import problem6.ListSizeVerifier

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

fun solution6(forms: List<List<String>>): List<String> {
    validateList(forms)

    return listOf()
}
