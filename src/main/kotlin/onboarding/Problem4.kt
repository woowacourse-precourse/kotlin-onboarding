package onboarding

fun solution4(word: String): String {
    /**
     * 기능목록
     * 1. 청개구리 사전에 대응하는 wordMap 선언
     * 2. word의 char를 하나씩 점검하여 wordMap에 있는 알파벳일 경우 대응하는 문자를 answer에 append
     *    wordMap에 없는 경우 원래 문자를 append
     * */

    /** 1. 청개구리 사전에 대응하는 wordMap 선언 */
    val wordMap = mapOf<String, String>(
        "A" to "Z", "B" to "Y", "C" to "X", "D" to "W", "E" to "V", "F" to "U", "G" to "T", "H" to "S", "I" to "R",
        "J" to "Q", "K" to "P", "L" to "O", "M" to "N", "N" to "M", "O" to "L", "P" to "K", "Q" to "J", "R" to "I",
        "S" to "H", "T" to "G", "U" to "F", "V" to "E", "W" to "D", "X" to "C", "Y" to "B", "Z" to "A",
        "a" to "z", "b" to "y", "c" to "x", "d" to "w", "e" to "v", "f" to "u", "g" to "t", "h" to "s", "i" to "r",
        "j" to "q", "k" to "p", "l" to "o", "m" to "n", "n" to "m", "o" to "l", "p" to "k", "q" to "j", "r" to "i",
        "s" to "h", "t" to "g", "u" to "f", "v" to "e", "w" to "d", "x" to "c", "y" to "b", "z" to "a",
    )

    /**
     * 2. word의 char를 하나씩 점검하여 wordMap에 있는 알파벳일 경우 대응하는 문자를 answer에 append
     *    wordMap에 없는 경우 원래 문자를 append
     * */
    val answer = StringBuilder()
    for (char in word){
        if (wordMap[char.toString()].isNullOrEmpty()){
            answer.append(char)
            continue
        }
        answer.append(wordMap[char.toString()])
    }
    return answer.toString()
}
