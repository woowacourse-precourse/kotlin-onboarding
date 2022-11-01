package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
    var word2 = word
    val len = word2.length
    for(i in 0..len-1){
        if(word2[i] in 'a'..'z'){
            val char = ('z'.code + 'a'.code - word2[i].code).toChar()
            word2 = word2.substring(0,i) + char + word2.substring(i+1)
        }
        else if(word2[i] in 'A'..'Z'){
            val char = ('Z'.code + 'A'.code - word2[i].code).toChar()
            word2 = word2.substring(0,i) + char + word2.substring(i+1)
        }
    }
    return word2
}
