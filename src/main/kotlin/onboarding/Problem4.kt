package onboarding

fun solution4(word: String): String {
    var str = ""
    for(element in word){
        str += reverseStr(element)
    }

    return str
}

fun reverseStr(num : Char) : Char{
    val temp : Int = num.code

    return when (temp) {
        in 65..90 -> (155 - temp).toChar()
        in 97 .. 122 -> (219 - temp).toChar()
        else -> num
    }
}
