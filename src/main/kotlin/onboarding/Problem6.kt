package onboarding

fun isValidNickname(nickname: String): Boolean {
    return nickname.matches("^[가-힣]{1,19}".toRegex())
}

fun isValidEmail(email: String): Boolean {
    return email.matches("""^[\w+-_.]{1,9}@email[.]com$""".toRegex())
}

fun isValidForm(form: List<String>): Boolean {
    return isValidEmail(form[0]) && isValidNickname(form[1])
}

private fun addTwoLengthWords(
    form: List<String>,
    map: HashMap<String, ArrayList<Int>>,
    index: Int
) {
    for (j in 1 until form[1].length) {
        val word = "${form[1][j - 1]}${form[1][j]}"
        if (map[word] == null) map[word] = arrayListOf(index)
        else map[word]!!.add(index)
    }
}

fun solution6(forms: List<List<String>>): List<String> {
    val twoLengthWordMap = hashMapOf<String, ArrayList<Int>>()

    forms.filter { form -> isValidForm(form) }
        .forEachIndexed { index, form ->
            addTwoLengthWords(form, twoLengthWordMap, index)
        }

    return twoLengthWordMap.filter { mapEntry -> mapEntry.value.size >= 2 }
        .flatMap { mapEntry -> mapEntry.value }
        .distinct()
        .map { duplicatedNicknameIndex -> forms[duplicatedNicknameIndex][0] }
        .toList().sorted()
}


