package onboarding

fun solution4(word: String): String {
    var str:String = word

    for (i in 0..str.length-1){
        if (isAlphabet(str[i]))
            str.replaceRange(i..i, (str[i]-1).toString())
    }

    return str
}

fun isAlphabet(x: Char): Boolean {
    if (x>= 'a' && x<= 'z')
        return true
    if (x>= 'A' && x<= 'Z')
        return true
    return false
}
