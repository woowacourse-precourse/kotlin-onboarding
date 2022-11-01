package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    TODO("프로그램 구현")
}

private fun getValidLengthEmailForms(forms: List<List<String>>): List<List<String>> {
    val processedForms = forms.toMutableList()
    for (i in forms) if (i[0].length !in 11..19) processedForms.remove(i)
    return processedForms
}

private fun getValidPatternEmailForms(forms: List<List<String>>): List<List<String>> {
    val processedForms = forms.toMutableList()
    for (i in forms) if (!Pattern.matches(
            "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+\$",
            i[0]
        )
    ) processedForms.remove(i)
    return processedForms
}

private fun getValidEmailDomainForms(forms: List<List<String>>): List<List<String>> {
    val processedForms = forms.toMutableList()
    for (i in forms) if ("email.com" !in i[0]) processedForms.remove(i)
    return processedForms
}

private fun getValidLengthNickNameForms(forms: List<List<String>>): List<List<String>> {
    val processedForms = forms.toMutableList()
    for (i in forms) if (i[1].length !in 1..19) processedForms.remove(i)
    return processedForms
}