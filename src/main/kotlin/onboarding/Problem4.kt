package onboarding
fun main(){

    println(solution4("I love you"))
}
fun solution4(word: String): String {
    val word = word
    var greenFrogWord = "" //return 할 청개구리 문자열
    for (index in word.indices){
        if (word[index] == ' '){ // 공백일때는 공백 추가
            greenFrogWord += ' '
        }
        else if(word[index].isUpperCase()){ // 대문자일 때
            val range = 65 + 90 // 아스키 코드 범위는 'A' ~ 'Z' = '65' ~ '90'
            val ascIICode = range - word[index].code // 대응되는 문자의 아스키코드
            greenFrogWord += ascIICode.toChar() // 문자로 변환 후 추가
        }
        else{ // 소문자일 때
            val range = 97 + 122 //아스키 코드 범위는 'a' ~ 'z' = '97' ~ '122'
            val ascIICode = range - word[index].code // 대응되는 문자의 아스키코드
            greenFrogWord += ascIICode.toChar() // 문자로 변환 후 추가
        }
    }
    return greenFrogWord
}
