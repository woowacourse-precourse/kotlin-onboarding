package onboarding
fun reverseAlphabet(num: Int):Int{
    // 알파벳 소문자의 경우
    if(num in 97..122)
        return num + ( 25 - 2 * (num - 97) )
    // 알파벳 대문자의 경우
    if(num in 65 .. 90)
        return num + ( 25 - 2 * (num - 65) )
    // 알파벳 그 외 문자
    return num
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
