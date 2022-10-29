package onboarding

fun main(args: Array<String>) {
    print(solution2(cryptogram = "browoanoommnaon"))
}

fun solution2(cryptogram: String): String {
}


fun hasDuplicates(cryptogram: String): Boolean {
    if (cryptogram.length != cryptogram.toCharArray().distinct().size) return true
    return false
}

