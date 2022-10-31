package onboarding

private lateinit var upper: Map<Char, Char>
private lateinit var lower: Map<Char, Char>

fun solution4(word: String): String {
    // 대문자를 Map으로 저장한다.
    upper = upperBoard()
    // 소문자를 Map으로 저장한다.
    lower = lowerBoard()
    // 들어온 문자열을 돌면서 대문자인지 소문자인지 판단한다.
    // map에 char를 키값으로 보내서 청개구리가 하는 말을 StringBuilder에 저장한다.
    return word.decode()
}

private fun String.decode(): String {
    val sb = StringBuilder()
    forEach {
        if (it.isUpper()) {
            sb.append(upper[it])
            return@forEach
        }
        if (it.isLower()) {
            sb.append(lower[it])
            return@forEach
        }
        sb.append(' ')
    }
    return sb.toString()
}

private fun Char.isLower() = this in 'a'..'z'

private fun Char.isUpper() = this in 'A'..'Z'

private fun upperBoard(): Map<Char, Char> {
    var alphaCount = 25
    val map = mutableMapOf<Char, Char>()
    for (i in 'A'..'Z') {
        map[i] = i + alphaCount
        alphaCount -= 2
    }
    return map
}

private fun lowerBoard(): Map<Char, Char> {
    var alphaCount = 25
    val map = mutableMapOf<Char, Char>()
    for (i in 'a'..'z') {
        map[i] = i + alphaCount
        alphaCount -= 2
    }
    return map
}


