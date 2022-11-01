package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

private fun getValidLengthEmailForms(forms: List<List<String>>): List<List<String>> {
    val processedForms = forms.toMutableList()
    for (i in forms) if (i[0].length !in 11..19) processedForms.remove(i)
    return processedForms
}
