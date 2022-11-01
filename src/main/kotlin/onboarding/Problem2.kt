package onboarding

fun solution2(cryptogram: String): String {
    var pw = cryptogram.toCharArray()
    while (true) {
        val overLapIndexList = crackPassword(pw)
        if (overLapIndexList.isEmpty()) break
        pw = removeOverlapIndex(overLapIndexList, pw)
    }
    return String(pw)
}

fun removeOverlapIndex(overLapIndexList: List<Int>, pw: CharArray): CharArray {
    for (idx in overLapIndexList) {
        pw[idx] = '+'
    }
    return String(pw).replace("+", "").toCharArray()
}

fun crackPassword(pw: CharArray): List<Int> {
    val list = mutableListOf<Int>()
    for (idx in 0 until pw.size - 1) {
        if (pw[idx] == pw[idx + 1]) {
            list.add(idx)
            list.add(idx + 1)
        }
    }
    return list
}