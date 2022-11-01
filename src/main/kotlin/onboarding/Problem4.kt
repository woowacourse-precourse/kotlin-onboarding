package onboarding

fun solution4(word: String): String {
   //아스키 코드 활용
    var frog_word : String = ""
    for(i in word){
        var frog_int :Int = i.toInt()
        frog_word += (219 - frog_int).toByte()
    }

    return frog_word
}
