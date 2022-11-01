package onboarding

fun solution4(word: String): String {
    var words = chageAlphabet(word)
    return words
}

fun chageAlphabet(words: String): String {

    val sl = words.toMutableList()

    for(i in sl.indices) {
        if(sl[i].isUpperCase()) {
            println("${sl[i]}는 대문자 입니다.")
            var temp = sl[i].code - 65
            var result = 90 - temp
            sl[i] = result.toChar()
        }
        else if(sl[i].isLowerCase()) {
            println("${sl[i]}는 소문자 입니다.")
            println(sl[i].code)
            var temp = sl[i].code - 97
            var result = 122 - temp
            println(result)
            println(result.toChar())
            sl[i] = result.toChar()
        }
    }

    return sl.joinToString("")

}