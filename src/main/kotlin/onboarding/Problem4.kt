package onboarding

fun solution4(word: String): String {

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