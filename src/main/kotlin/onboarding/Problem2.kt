package onboarding

fun solution2(cryptogram: String): String {
    var cryptogram = cryptogram

    if (isCorrect(cryptogram)) {

    } else return "wrong cryptogram"
}


fun isCorrect(cryptogram: String): Boolean {
    val condition1 = (cryptogram.length >= 1) && (cryptogram.length <= 1000)
    var condition2 = true
    for (i in cryptogram.indices) if (cryptogram[i] !in 'a'..'z') {
        condition2 = false
        break
    }
    return condition1 && condition2
}