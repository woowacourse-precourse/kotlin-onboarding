package onboarding

fun solution2(cryptogram: String): String {
    val cryptoArray = cryptogram.toMutableList()

    var result: String = ""
    result = fixArray(cryptoArray)
    println(result)

    return result
}

fun fixArray(newcrypto: MutableList<Char>): String {
    var result: String = ""
    for (i in 1 until newcrypto.size) {
        if (newcrypto[i-1] == newcrypto[i]) {
            newcrypto.removeAt(i-1)
            newcrypto.removeAt(i-1)
            fixArray(newcrypto)
            return fixArray(newcrypto)
        }
    }

    result = newcrypto.joinToString("")
    println(result)
    return result
}



