package onboarding

import java.util.regex.Pattern

fun solution6(forms: List<List<String>>): List<String> {
    var validForms = forms
    validForms = getValidLengthEmailForms(validForms)
    validForms = getValidPatternEmailForms(validForms)
    validForms = getValidEmailDomainForms(validForms)
    validForms = getValidLengthNickNameForms(validForms)
    validForms = getValidLanguageNickNameForms(validForms)

    return getDuplicateNicKNameFormEmailList(validForms).sorted()
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

private fun getValidLanguageNickNameForms(forms: List<List<String>>): List<List<String>> {
    val processedForms = forms.toMutableList()
    for (i in forms) if (!Pattern.matches("^[ㄱ-ㅣ가-힣 ]*$", i[1])) processedForms.remove(i)
    return processedForms
}

private fun getDuplicateNicKNameFormEmailList(forms: List<List<String>>): MutableList<String> {
    val duplicateNicKNameFormEmailSet = mutableSetOf<String>()
    for (i in forms.indices) {
        for (j in 0 until forms[i][1].length - 1) {
            val checkString = forms[i][1].substring(j, j + 2)
            for (k in i + 1 until forms.size) {
                if (checkString in forms[k][1]) duplicateNicKNameFormEmailSet.addAll(listOf(forms[i][0], forms[k][0]))
            }
        }
    }
    return duplicateNicKNameFormEmailSet.toMutableList()
}