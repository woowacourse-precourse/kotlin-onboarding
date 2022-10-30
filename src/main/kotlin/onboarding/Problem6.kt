package onboarding

fun solution6(forms: List<List<String>>): List<String> {
    val result = mutableSetOf<String>()

    for (indexList in forms.indices) {
        val name = forms[indexList][1]
        val email = forms[indexList][0]
        for (nameIndex in 0 until name.length - 1) {
            val twoLetters = name.substring(nameIndex, nameIndex + 2)
            for (index in forms.indices) {
                if (forms[index][1].contains(twoLetters) && indexList != index) {
                    result.add(email)
                }
            }
        }
    }
    return result.toMutableList().sorted()
}
