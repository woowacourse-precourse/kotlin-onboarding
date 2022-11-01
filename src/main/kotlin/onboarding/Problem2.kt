package onboarding

fun solution2(cryptogram: String): String {
    val cryptoArray = cryptogram.toMutableList()

    for (i in 1 until cryptoArray.size) {

        if (cryptoArray[i-1] == cryptoArray[i]) {
            cryptoArray.removeAt(i)
            cryptoArray.removeAt(i-1)
        }
    }

    val newcrypto : String = cryptoArray.toString()

    return newcrypto

}



