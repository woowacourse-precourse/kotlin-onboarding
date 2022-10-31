package onboarding

import java.util.regex.Pattern


fun solution4(word: String): String {
    if(!checkValidInput(word))
        throw IllegalArgumentException("invalid input found!")

    return ""
}
fun checkValidInput(word: String): Boolean{
    return Pattern.matches("^[a-zA-Z\\s]*\$",word )
}

fun getConvertedWord(word: String): String{
    // TODO: 2022-11-01
    return ""
}

fun convertChar(originalChar: Char): Char {
    // TODO: 2022-11-01
    return 'a'
}

