package onboarding

fun solution4(cryptogram: String): String {
    var result = ""
    val maxSumOfLowerCase = 'a'.toInt() + 'z'.toInt()
    val maxSumOfUpperCase = 'A'.toInt() + 'Z'.toInt()

    if (isCorrect4(cryptogram)) {
        for (i in cryptogram)
            when (i) {
                in 'a'..'z' -> result += (maxSumOfLowerCase - i.toInt()).toChar()
                in 'A'..'Z' -> result += (maxSumOfUpperCase - i.toInt()).toChar()
                else -> result += i
            }
        return result
    }
    else return "wrong cryptogram"
}

fun isCorrect4(cryptogram: String): Boolean {
    val condition1 = cryptogram.length in 1..1000
    return condition1
}


