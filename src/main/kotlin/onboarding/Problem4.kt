package onboarding

const val TO_LOWER_CASE = 32
const val MAPPING_STEP = 25

fun solution4(word: String): String {
    var answer = ""
    val upperAlphabet = listOf('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
    val mapping: MutableMap<Char, Char> = mutableMapOf()

    makeMap(upperAlphabet, mapping)

    word.forEach { c ->
        answer += if (c.isLetter())
            mapping[c]
        else c
    }

    return answer
}

// mapping 시키기
private fun makeMap(upperAlphabet: List<Char>, mapping: MutableMap<Char, Char>) {
    for (i in upperAlphabet.indices) {
        mapping[upperAlphabet[i]] = upperAlphabet[MAPPING_STEP - i]
        mapping[upperAlphabet[i] + TO_LOWER_CASE] = upperAlphabet[MAPPING_STEP - i] + TO_LOWER_CASE
    }
}