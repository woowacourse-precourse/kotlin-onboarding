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

fun getChangeChar(ch: Char): Char {
    return if(checkLower(ch)) {
        _frogDictionary[ch.uppercaseChar()]!!.lowercaseChar()
    }
    else {
        if(checkNull(_frogDictionary[ch]))
            ch
        else
            _frogDictionary[ch]!!
    }
}


fun solution4(word: String): String {
    setDictionary()
    var result = ""

    for(i in word.indices) {
        val ch = getChangeChar(word[i])
        result += ch
    }

    return result
}
