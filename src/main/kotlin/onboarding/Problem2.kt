package onboarding

fun solution2(cryptogram: String): String {
    var cryptogram = cryptogram

    if (isCorrect(cryptogram)) {
        cryptogram  = cryptogram.lowercase()
        while (true) {
            val cryptogramNumList = arrayListOf<Int>()
            for (i in 0..cryptogram.length - 2) if (cryptogram[i] == cryptogram[i + 1]) cryptogramNumList.add(i)

        }
        return cryptogram
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