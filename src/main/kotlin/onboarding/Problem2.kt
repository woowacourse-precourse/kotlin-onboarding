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

fun removeChar(cryptogram: String, positions: MutableSet<Int>): String {
    var result = ""

    for(i in cryptogram.indices) {
        if(!positions.contains(i)) {
            result += cryptogram[i]
        }
    }

    return result
}