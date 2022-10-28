package onboarding

const val DIFF_UPPER_LOWER_LETTER = 32
const val MAPPING_STEP = 25

fun solution4(word: String): String {
    var answer = ""
    val alphaList = listOf<Char>('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
    val mapping: MutableMap<Char, Char> = mutableMapOf()

    makeMap(alphaList, mapping)

    word.forEach {
        if (it.isLetter())
            answer += mapping[it]
        else if (!it.isLetter())
            answer += it
    }

    return answer
}

// mapping 시키기
private fun makeMap(alphaList: List<Char>, mapping: MutableMap<Char, Char>){
    for (i in alphaList.indices) {
        mapping[alphaList[i]] = alphaList[MAPPING_STEP - i]
        mapping[alphaList[i] + DIFF_UPPER_LOWER_LETTER] = alphaList[MAPPING_STEP - i] + DIFF_UPPER_LOWER_LETTER
    }
}