package onboarding

fun solution4(word: String): String {
    var result = ""
    for (i in word){
        // add word by reversed dictionary
        result += if (i.isUpperCase()) 'Z' - (i-'A')
                  else if (i.isLowerCase()) 'z' - (i-'a')
                  else i // not alphabet
    }
    return result
}
