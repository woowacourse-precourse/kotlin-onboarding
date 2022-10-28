package onboarding

fun solution4(word: String): String {
    val upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val lowerCase = "abcdefghijklmnopqrstuvwxyz"
    val alphabetMap = mutableMapOf<Char, Char>()
    for (i in 0 until 26) {
        alphabetMap[upperCase[i]] = upperCase[25 - i]
        alphabetMap[lowerCase[i]] = lowerCase[25 - i]
    }

    TODO("프로그램 구현")
}
