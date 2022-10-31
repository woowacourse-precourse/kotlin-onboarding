package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()

    for (indexList in forms.indices) {
        val email = forms[indexList][0]
        if (checkNickName(indexList, forms)) result.add(email)
    }
    return result.toList().sorted()
}

private fun checkNickName(indexList: Int, forms: List<List<String>>): Boolean {
    val name = forms[indexList][1]
    for (nameIndex in 0 until name.length - 1) {
        val twoLetters = name.substring(nameIndex, nameIndex + 2)
        for (index in forms.indices) {
            if (forms[index][1].contains(twoLetters) && indexList != index) {
                return true
            }
        }
    }
    return false
}