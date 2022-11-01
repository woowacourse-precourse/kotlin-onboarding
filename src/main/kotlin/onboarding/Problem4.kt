package onboarding

fun solution4(word: String): String {
    val flog = mutableMapOf<String, String>()
    var ans = ""

    for (i in 0..25) {
        flog[('a' + i).toString()] = ('z' - i).toString()
        flog[('A' + i).toString()] = ('Z' - i).toString()
    }

    for (i in word) {
        ans += flog[i.toString()]
    }
    return ans
}

fun main() {
//    val word = "I love you"
//    val result = "R olev blf"
    val word = "Iloveyou"
    val result = "Rolevblf"
    print(solution4(word).equals(result))
}
