package onboarding

import problem6.ListSizeVerifier
import problem6.ListSorter

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

fun solution6(forms: List<List<String>>): List<String> {
    validateList(forms)

    createOrderedForms(forms)
    
    return listOf()
}
