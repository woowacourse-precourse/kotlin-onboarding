package onboarding

/*
어느 연못에 엄마 말씀을 좀처럼 듣지 않는 청개구리가 살고 있었다.
청개구리는 엄마가 하는 말은 무엇이든 반대로 말하였다.
엄마 말씀 word가 매개변수로 주어질 때,
아래 청개구리 사전을 참고해 반대로 변환하여 return 하도록 solution 함수를 완성하라.
*/

// word 1 .. 1000
// A 65 Z 90 a 97 z 122

fun alphaChange(alpha: Char): Char { // 변환된 문자를 return
    var letter = ' '
    var ascii = 0
    ascii = alpha.toInt()
    // 대문자일때
    if (ascii in 65..90) {
        letter = (90 - (ascii - 65)).toChar()
    }
    // 소문자일때
    else if(ascii in 97 .. 122){
        letter = (122 - (ascii - 97)).toChar()
    }
    // 스페이스일때 스페이스만 추가함
    if (ascii == 32) {
        letter=' '
    }

    return letter
}

fun solution4(word: String): String {
    var result = ""
    for (i in 0 until word.length) {
        result+= alphaChange(word[i])
    }
    return result
}