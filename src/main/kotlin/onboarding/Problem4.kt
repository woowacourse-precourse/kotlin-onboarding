package onboarding

var _frogDictionary: MutableMap<Char, Char> = mutableMapOf()

fun setDictionary() {
    var ch = 'Z'
    for(alpha in 'A' .. 'Z') {
        _frogDictionary[alpha] = ch
        ch -= 1
    }
}

fun checkNull(ch: Char?): Boolean {
    return ch == null
}

fun checkLower(ch: Char): Boolean {
    return ch -'Z' > 0
}

fun solution4(word: String): String {
    setDictionary()
    var result = ""

    return result
}
