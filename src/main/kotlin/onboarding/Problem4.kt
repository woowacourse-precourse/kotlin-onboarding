package onboarding

fun solution4(word: String): String {
    // 대문자를 Map으로 저장한다.
    // 소문자를 Map으로 저장한다.
    // 들어온 문자열을 돌면서 대문자인지 소문자인지 판단한다.
    // map에 char를 키값으로 보내서 청개구리가 하는 말을 StringBuilder에 저장한다.
    TODO("프로그램 구현")
}

private fun upperBoard(): Map<Char, Char> {
    var alphaCount = 25
    val map = mutableMapOf<Char, Char>()
    for (i in 'A'..'Z') {
        map[i] = i + alphaCount
        alphaCount--
    }
    return map
}

private fun lowerBoard(): Map<Char, Char> {
    var alphaCount = 25
    val map = mutableMapOf<Char, Char>()
    for (i in 'a'..'z') {
        map[i] = i + alphaCount
        alphaCount--
    }
    return map
}

