package onboarding

fun solution4(word: String): String {

    if(inputStateCheck4(word) == "") return ""

    var result : String = ""

    for(i in word.indices) {
        if((word[i].code in 97..122) || word[i].code in 65..90) {
            if(word[i].isUpperCase()) result += (155 - word[i].code).toChar()
            if(word[i].isLowerCase()) result += (219 - word[i].code).toChar()
        }
        else {
            result += word[i]
        }
    }

    return result
}

fun inputStateCheck4(word: String): String {
    if(word.isEmpty()) return ""
    if(word.length > 1000) return ""

    return "word"
}