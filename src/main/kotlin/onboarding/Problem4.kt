package onboarding

fun solution4(word: String): String {
    val lowerCaseMap = mappingLowerCase()
    val upperCaseMap = mappingUpperCase()

    var sonFrog = ""
    var i = 0



    while (i < word.length) {

        if (word[i] == ' ') {
            sonFrog += ' '
            i++
        } else if (word[i] in 'a'..'z') {
            sonFrog += lowerCaseMap.getValue(word[i]).toString()
            i++
        } else if (word[i] in 'A'..'Z') {
            sonFrog += upperCaseMap.getValue(word[i]).toString()
            i++
        }
    }
    return sonFrog
}

fun mappingLowerCase(): MutableMap<Char, Char> {
    var temp = 0
    val lowerCase = mutableMapOf<Char, Char>()
    for (i in 'a'..'z') {
        temp++
        val reverseLowerCase = (123 - temp).toChar()
        lowerCase[i] = reverseLowerCase

    }
    return lowerCase
}

fun mappingUpperCase(): MutableMap<Char, Char> {
    var temp = 0
    val upperCase = mutableMapOf<Char, Char>()
    for (i in 'A'..'Z') {
        temp++
        val reverseUpperCase = (91 - temp).toChar()
        upperCase[i] = reverseUpperCase

    }
    return upperCase
}