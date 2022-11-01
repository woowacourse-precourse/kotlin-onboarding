package onboarding

fun solution4(word: String): String {
    val flog = mutableMapOf<String, String>()
    var ans = ""

    for (i in 0..25) {
        flog[('a' + i).toString()] = ('z' - i).toString()
        flog[('A' + i).toString()] = ('Z' - i).toString()
    }

    for (i in word) {
        ans += if (flog.containsKey(i.toString()))
            flog[i.toString()]
        else
            i.toString()
    }

    return ans
}

