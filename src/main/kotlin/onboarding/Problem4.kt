package onboarding

fun solution4(word: String): String {
    var str: String = word

    for (i in str.indices){
        str = changeWord(str, i)
    }
    return str
}

fun changeWord(str: String, i: Int): String {
    if (str[i] in 'a'..'z'){
        return str.replaceRange(i..i,('z' - (str[i] - 'a')).toString())
    }
    if (str[i] in 'A'..'Z'){
        return str.replaceRange(i..i,('Z' - (str[i] - 'A')).toString())
    }
    return str
}