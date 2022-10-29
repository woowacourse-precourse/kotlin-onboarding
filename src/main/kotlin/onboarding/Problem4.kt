package onboarding

val frogDocs: Array<Char> = initDocs()
fun solution4(word: String): String {
    val sb = StringBuilder(word)
    val len = sb.length
    for(i in 0 until len) {
        sb.append(inverseChar(sb[i]))
    }
    sb.delete(0, len)

    return sb.toString()
}

// init frogDocs
fun initDocs() : Array<Char> {
    val docs = Array('z'.code + 1) {'0'}
    for(i in 0..25) {
        docs['a'.code + i] = ('z'.code - i).toChar()
        docs['A'.code + i] = ('Z'.code - i).toChar()
    }
    return docs
}
fun isUppercaseChar(ch: Char): Boolean {
    if(ch.code >= 'A'.code && ch.code <= 'Z'.code)
        return true
    return false
}

fun isLowercaseChar(ch : Char): Boolean {
    if(ch.code >= 'a'.code && ch.code <= 'z'.code)
        return true
    return false
}

fun inverseChar(ch: Char): Char {
    if(isUppercaseChar(ch) || isLowercaseChar(ch))
        return frogDocs[ch.code]
    return ch
}
