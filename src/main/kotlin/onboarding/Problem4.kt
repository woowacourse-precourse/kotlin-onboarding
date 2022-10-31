package onboarding

fun solution4(word: String): String {
//    'A'+'Z' = 155
//    'a'+'z'=219
    var result = ""
    for (idx: Int in word.indices) {
        if(word[idx].isWhitespace()) {
            result += word[idx]
            continue
        }

        if(word[idx].isUpperCase()) {
            result += (155-word[idx].code).toChar()
        } else { // isLowerCase
            result += (219-word[idx].code).toChar()
        }
    }
    return result
}