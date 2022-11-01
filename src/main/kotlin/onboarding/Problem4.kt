package onboarding

fun solution4(word: String): String {
    var str = ""
    for (i in word.indices) {
        if ((word[i] in 'A'..'Z') || (word[i] in 'a'..'z')) {
            str += transform(word[i]).toChar()
        } else {
            str += word[i]
        }
    }
    return str
}

fun transform(ch: Char): Int {
    val A = 'A'.code
    val Z = 'Z'.code
    val a = 'a'.code
    val z = 'z'.code
    var reverseNum = 0
    if (ch in 'A'..'Z') {
        reverseNum = A + Z - ch.code
    }
    if (ch in 'a'..'z') {
        reverseNum = a + z - ch.code
    }
    return reverseNum
}