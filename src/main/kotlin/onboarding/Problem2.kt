package onboarding

fun solution2(cryptogram: String): String {

    val cryptoArray = cryptogram.lowercase().toMutableList()
    var result: String = ""

    result = fixArray(cryptoArray)
    println(result)

    return result
}

fun fixArray(newcrypto: MutableList<Char>): String {
    var result: String = ""
    if (newcrypto.size in 1..1000) {
        for (i in 1 until newcrypto.size) {
            if (newcrypto[i - 1] == newcrypto[i]) {
                newcrypto.removeAt(i - 1)
                newcrypto.removeAt(i - 1)
                fixArray(newcrypto)
                return fixArray(newcrypto)
            }
        }
    } else return result

    result = newcrypto.joinToString("")
    println(result)
    return result
}



