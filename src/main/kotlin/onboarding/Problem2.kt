package onboarding

fun solution2(cryptogram: String): String {
    val answer = "answer"
    return answer
}

/* 문자가 담긴 list를 String형태로 변환 기능 */
fun listToString(temp: List<Char>): String {
    val str = StringBuilder()
    for (cryptoChar in temp) str.append(cryptoChar)
    return str.toString()
}