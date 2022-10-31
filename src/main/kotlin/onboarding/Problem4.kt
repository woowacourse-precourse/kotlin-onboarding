package onboarding

fun solution4(word: String): String {
    val sb = StringBuilder()
    var ascii: Int

    word.toCharArray().forEach {
        when (it) {
            in 'a' .. 'z' -> {
                ascii = 'z'.code - it.code + 'a'.code
                sb.append(ascii.toChar())
            }
            in 'A' .. 'Z' -> {
                ascii = 'Z'.code - it.code + 'A'.code
                sb.append(ascii.toChar())
            }
            else -> sb.append(it)
        }
    }

    return sb.toString()
}