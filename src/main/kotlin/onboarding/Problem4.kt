package onboarding

fun solution4(word: String): String {

    return word.toCharArray()
        .map { alphabet ->
            val capitalLetterReturn = ('A'.code + 'Z'.code - alphabet.code).toChar()
            val smallLetterReturn = ('a'.code + 'z'.code - alphabet.code).toChar()

            when (alphabet) {
                in 'A'..'Z' -> capitalLetterReturn
                in 'a'..'z' -> smallLetterReturn
                else -> alphabet
            }
        }.joinToString(AS_DELETE_BLANK)
}

const val AS_DELETE_BLANK = ""