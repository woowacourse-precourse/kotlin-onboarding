package onboarding

// 알파벳 변환 함수
fun change_alphabet(c: Char): Char {
    var num = c.code
    if (num == 32)
        return 32.toChar()
    else if (num < 93)
        return ((155 - num).toChar())
    else
        return ((219 - num).toChar())
}

fun solution4(word: String): String {
    var size = word.length
    var f_word: String = ""
    for (i in 0..size - 1)
        f_word += change_alphabet(word[i])
    return f_word

}
