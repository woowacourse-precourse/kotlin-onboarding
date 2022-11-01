package onboarding

fun solution4(word: String): String {
    return translate(word)
}

fun translate(word: String): String { // 문자열 검사 및 치환

    val momFrog = word
    var sonFrog = ""
    for (i in momFrog.indices) {

        if (momFrog[i] == ' ') {
            sonFrog += ' '

        } else if (momFrog[i] in 'a'..'z') {
            sonFrog += mappingLowerCase().getValue(momFrog[i]).toString()

        } else if (momFrog[i] in 'A'..'Z') {
            sonFrog += mappingUpperCase().getValue(momFrog[i]).toString()

        }
    }

    return sonFrog
}

fun mappingLowerCase(): MutableMap<Char, Char> { // 소문자 Map 리스트 구현
    var temp = 0
    val lowerCase = mutableMapOf<Char, Char>()
    for (i in 'a'..'z') {
        temp++
        val reverseLowerCase = (123 - temp).toChar()
        lowerCase[i] = reverseLowerCase
    }
    return lowerCase
}

fun mappingUpperCase(): MutableMap<Char, Char> { // 대문자 Map 리스트 구현
    var temp = 0
    val upperCase = mutableMapOf<Char, Char>()
    for (i in 'A'..'Z') {
        temp++
        val reverseUpperCase = (91 - temp).toChar()
        upperCase[i] = reverseUpperCase
    }
    return upperCase
}