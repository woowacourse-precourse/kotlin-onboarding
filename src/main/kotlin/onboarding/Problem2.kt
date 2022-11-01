package onboarding

fun solution2(cryptogram: String): String {

}

fun getDuplicateCharIndex(cryptogram: String): MutableSet<Int> {
    val result = mutableSetOf<Int>()

    for(i in cryptogram.indices) {
        if(cryptogram[i] == cryptogram[i + 1]) {
            result.add(i)
            result.add(i + 1)
        }
    }

    return result
}