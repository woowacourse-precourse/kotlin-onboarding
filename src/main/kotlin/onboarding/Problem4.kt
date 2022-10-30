package onboarding
fun reverseAlphabet(num: Int):Int{
    return 97
}
fun solution4(word: String): String {
    var result=""
    for(w in word){
        val data = w.code
        // 문자열 변환
        result += reverseAlphabet(data).toChar()
    }
    return result
}
