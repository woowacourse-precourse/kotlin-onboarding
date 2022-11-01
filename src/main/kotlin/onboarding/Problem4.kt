package onboarding

fun changeASCIICode(i: Int): Char{
    var answer: Int = i
    if(i in 65..90){
        answer = 155 - i
    }
    if(i in 97..122){
        answer = 219 - i
    }
    return answer.toChar()
}
fun solution4(word: String): String {
    var answer: String = ""
    for(i: Int in 0..word.length-1){
        answer += changeASCIICode(word[i].code)
    }
    return answer
}