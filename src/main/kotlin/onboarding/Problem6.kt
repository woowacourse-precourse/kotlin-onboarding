package onboarding

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

    for ((index, form) in forms.withIndex()) {
        addTwoLengthWords(form, twoLengthWordMap, index)
    }

    return twoLengthWordMap.filter { mapEntry -> mapEntry.value.size >= 2 }
        .flatMap { mapEntry -> mapEntry.value }
        .distinct()
        .map { duplicatedIndex -> forms[duplicatedIndex][0] }
        .toList().sorted()
}