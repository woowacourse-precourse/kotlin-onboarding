package onboarding

fun solution4(word: String): String {
    var Str :String = ""
    for (i in word){
        var a = i
        var b = 0
        if (a.toInt() <91) b = 90 - a.toInt() + 65
        else b = 112 - a.toInt() + 65
        if (i == word[0]) Str = b.toString()
        else Str += b.toString()
    }
    return Str
}