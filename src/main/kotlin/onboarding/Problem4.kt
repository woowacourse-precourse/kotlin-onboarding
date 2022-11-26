package onboarding

//- 알파벳을 반대로 출력 하는 기능

const val LOWER_START_ALPHABET = 'a'
const val LOWER_END_ALPHABET = 'z'
const val UPPER_START_ALPHABET = 'A'
const val UPPER_END_ALPHABET = 'Z'
fun solution4(word: String): String {
    TODO("프로그램 구현")
}



private fun alphabetRange(start:Char,end:Char) = (start..end).toList()
private fun reverseLowerAlphabets(): Map<Char, Char> {
    val lowerAlphabetsMap = mutableMapOf<Char, Char>()
    val lowerAlphabets = (LOWER_START_ALPHABET..LOWER_END_ALPHABET).toList()
    for (i in lowerAlphabets.indices) {
        lowerAlphabetsMap[lowerAlphabets[i]] = lowerAlphabets.reversed()[i]
    }

    return lowerAlphabetsMap
}

private fun reverseUpperAlphabets(): Map<Char, Char> {
    val upperAlphabetsMap = mutableMapOf<Char, Char>()
    val upperAlphabets = (UPPER_START_ALPHABET..UPPER_END_ALPHABET).toList()
    for (upperAlphabet in upperAlphabets.indices) {
        upperAlphabetsMap[upperAlphabets[upperAlphabet]] = upperAlphabets.reversed()[upperAlphabet]
    }
    return upperAlphabetsMap
}

private fun isAlphabet(alphabet: Char): Boolean {
    val regex = (UPPER_START_ALPHABET..LOWER_END_ALPHABET).toList()
    return regex.contains(alphabet)
}