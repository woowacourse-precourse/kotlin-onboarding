package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
    var result = ""
    for (ch in word) {
        if(ch.isUpperCase()) {
            result += ('Z'.code - (ch.code - 'A'.code)).toChar()
        }
        else if(ch.isLowerCase()) {
            result += ('z'.code - (ch.code - 'a'.code)).toChar()
        }
        else {
            result += " "
        }
    }
    //print(result)
    return result
}
