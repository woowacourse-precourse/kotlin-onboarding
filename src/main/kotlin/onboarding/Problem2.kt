package onboarding

fun solution2(_cryptogram: String): String {
    var cryptogram = _cryptogram

    while(true) {
        val positions = getDuplicateCharIndex(cryptogram)

        if(positions.isEmpty()) {
            break
        }

        cryptogram = removeChar(cryptogram, positions)
    }

    return cryptogram
}

fun getDuplicateCharIndex(cryptogram: String): MutableSet<Int> {
    val result = mutableSetOf<Int>()

    for(i in 0 until cryptogram.length - 1) {
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