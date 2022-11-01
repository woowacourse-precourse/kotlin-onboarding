package onboarding

/* 문제 해결 */
fun solution4(word: String): String {
    var answer = ""
    val ch = word.toCharArray()
    for (i in ch.indices) {
        val a = divideCase(ch[i])
        if (a == 1) {
            answer = answer + (219 - ch[i].code).toChar()
            continue
        }
        if (a == 2) {
            answer = answer + (155 - ch[i].code).toChar()
            continue
        }
        answer += ch[i]
    }
    return answer
}

/* 소문자, 대문자 구별하는 기능 */
fun divideCase(c: Char): Int {
    if (c.code >= 97 && c.code <= 122) return 1 //소문자
    return if (c.code >= 65 && c.code <= 90) 2 else 0 //대문자
}
