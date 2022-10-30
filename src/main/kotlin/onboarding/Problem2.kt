package onboarding

fun solution2(cryptogram: String): String {
    var mutableCryptogram = cryptogram
    while (true) {
        var isChanged = false

        var idx = 0
        while (idx + 1 < mutableCryptogram.length) {
            val firstChar = mutableCryptogram[idx]
            val secondChar = mutableCryptogram[idx + 1]

            if (firstChar == secondChar) {
                mutableCryptogram = mutableCryptogram.replace("$firstChar$firstChar", "")
                isChanged = true
            } else {
                idx += 1
            }
        }

        if (isChanged.not()) break
    }
    return mutableCryptogram

}
