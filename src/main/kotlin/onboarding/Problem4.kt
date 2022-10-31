package onboarding

fun solution4(word: String): String {
    val alphaMap = HashMap<Char, Char>()
    for (i: Int in 0 until 26) {
        alphaMap.put((65 + i).toChar(), (90 - i).toChar())
        alphaMap.put((97 + i).toChar(), (122 - i).toChar())
    }
    var answer = ""
    for (k in word) {
        if (k in alphaMap)
            answer += alphaMap[k]
        else
            answer += k
    }

    return answer
}

fun main() {
    val word = "A, AA, aa, ZZ, z"
    println(solution4(word))
}