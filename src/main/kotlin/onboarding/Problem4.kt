package onboarding

fun solution4(word: String): String {
    var result = ""
    for (i in word){
        result += if (i.isUpperCase()) 'Z' - (i-'A')
                  else if (i.isLowerCase()) 'z' - (i-'a')
                  else i
    }
    return result
}
