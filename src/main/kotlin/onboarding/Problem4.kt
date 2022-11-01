package onboarding

fun solution4(word: String) : String{
    //TODO("프로그램 구현")
    var word1 = word
    var len = word1.length
    var reverseStr = ""
    var reverseWord = 'a'
    var temp = 0

    for (i : Int in 0 until len) {
        if (word1[i].toInt() in 65..90) {
            temp = word[i].toInt() - 65
            reverseWord = (word1[i].toInt() + 25 - (temp * 2)).toChar()
            reverseStr += reverseWord
        }
        if (word[i].toInt() in 97..122) {
            temp = word[i].toInt() - 97
            reverseWord = (word1[i].toInt() + 25 - (temp*2)).toChar()
            reverseStr += reverseWord
        }
        if (word[i].toInt() in 0..64)
            reverseStr += word[i]
        if (word[i].toInt() in 91..96)
            reverseStr += word[i]
        if (word[i].toInt() in 123..127)
            reverseStr += word[i]
    }
    return reverseStr
}