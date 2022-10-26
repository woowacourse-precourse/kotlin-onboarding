package onboarding

fun solution4(word: String): String {
    var str:String = word

    for (i in 0..str.length-1){
        if (str[i] >= 'a' && str[i] <= 'm'){
            str = str.replaceRange(i..i,('z' - (str[i] - 'a')).toString())
        }
        else if (str[i] >= 'n' && str[i] <= 'z'){
            str = str.replaceRange(i..i,('a' + ('z' - str[i])).toString())
        }
        if (str[i] >= 'A' && str[i] <= 'M'){
            str = str.replaceRange(i..i,('Z' - (str[i] - 'A')).toString())
        }
        else if (str[i] >= 'N' && str[i] <= 'Z'){
            str = str.replaceRange(i..i,('A' + ('Z' - str[i])).toString())
        }
    }
    return str
}
