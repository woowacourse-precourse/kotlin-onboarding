package onboarding

fun solution4(word: String): String {
    var result =""
    for(i in word){
        result+=changeChar(i)
    }
    return result
}
fun isAlpha(c:Char): Boolean {
    var ascii= c.toInt()
    if((ascii>=65 && ascii<=90) ||(ascii>=97 && ascii<=122)){
        return true
    }
    return false
}

fun changeChar(c: Char):Char{
    if(!isAlpha(c)){
        return c
    }
    if(c.isUpperCase()){
        return changeUpper(c)
    }
    return changeLower(c)
}
fun changeUpper(c : Char): Char {
    return (155-c.toInt()).toChar()
}
fun changeLower(c : Char): Char {
    return (219-c.toInt()).toChar()
}
