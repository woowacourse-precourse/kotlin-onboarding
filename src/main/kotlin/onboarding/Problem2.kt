package onboarding

fun main(args: Array<String>) {
    print(solution2(cryptogram = "browoanoommnaon"))
}

fun solution2(cryptogram: String): String {

}


fun decryption(cryptogram: String): String {
    var targetStr = cryptogram

    do {
        targetStr = targetStr.toCharArray().distinct().joinToString("")
    } while (hasDuplicates(cryptogram = cryptogram))

    return targetStr
}

fun hasDuplicates(cryptogram: String): Boolean {
    if (cryptogram.length != cryptogram.toCharArray().distinct().size) return true
    return false
}

