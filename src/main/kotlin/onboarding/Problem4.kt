package onboarding

fun solution4(word: String): String {
    var str = ""
    for(element in word){
        str += getAscIICode(element)
    }

    return str
}

fun getAscIICode(num : Char) : Char{
    val temp : Int = num.code

    return if(num == ' ')
        ' '
    else if(temp in 65..90)
        (155 - temp).toChar()
    else if(temp in 97 .. 122)
        (219 - temp).toChar()
    else
        num
}
