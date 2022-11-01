package onboarding

fun solution4(word: String): String {
    var str = word
    var k = 0
    var answer = ""
    for(i in 0..str.length-1){

        if(str[i].code in 65..90){  // 대문자
            k = (155 - str[i].code)
            answer += k.toChar()
        }
        else if(str[i].code in 97..122){  // 소문자
            k = (219 - str[i].code)
            answer += k.toChar()
        }
        else{
            answer += str[i]
        }

    }
    return answer
}