package onboarding

/**
기능 목록
- 청개구리 사전 순으로 문자 변환 map 만들기 (ex. mapping['A'] = 'Z', mapping['a'] = 'z')
- word를 돌면서 알파벳인 경우에는 answer에 변환한 문자 추가, 그 외에는 그대로 문자 추가
- makeMap : 청개구리 사전으로 mapping 시키기
 */

const val TO_LOWER_CASE = 32
const val MAPPING_STEP = 25

fun solution4(word: String): String {
    var answer = ""
    val upperAlphabet = listOf('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
    val mapping = mutableMapOf<Char, Char>()

    makeMap(upperAlphabet, mapping)

    word.forEach { c ->
        answer += if (c.isLetter())
            mapping[c]
        else c
    }

    return answer
}

private fun makeMap(upperAlphabet: List<Char>, mapping: MutableMap<Char, Char>) {
    for (i in upperAlphabet.indices) {
        mapping[upperAlphabet[i]] = upperAlphabet[MAPPING_STEP - i]
        mapping[upperAlphabet[i] + TO_LOWER_CASE] = upperAlphabet[MAPPING_STEP - i] + TO_LOWER_CASE
    }
}