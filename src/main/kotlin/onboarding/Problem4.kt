package onboarding

fun solution4(cryptogram: String): String {
    var result = ""
    val maxSumOfLowerCase = 'a'.toInt() + 'z'.toInt()
    val maxSumOfUpperCase = 'A'.toInt() + 'Z'.toInt()

    if (isCorrect4(cryptogram)) {

    }
    else return "wrong cryptogram"
}

fun isCorrect4(cryptogram: String): Boolean {
    val condition1 = cryptogram.length in 1..1000
    return condition1
}


