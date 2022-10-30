package onboarding

fun solution2(cryptogram: String): String {
    var before = cryptogram
    var after = decode(before)
    // 암호 해독
    while (before != after) {
        before = after
        after = decode(before)
    }
    return after
}

private fun decode(cryptogram: String): String {
    val str = cryptogram.map { it.toString() }.toMutableList()
    for (i in 0 until str.size - 1) {
        if (str[i] == str[i + 1]) {
            str[i] = ""
            str[i + 1] = ""
        }
    }
    return str.joinToString("")
}