package onboarding

import kotlin.math.abs

/**
 * 기능목록
 * (1) 문자열을 한 글자씩 분리
 * (2) 아스키코드 번호를 활용하여 각 문자의 역순 알파벳 번호를 찾아주고, 역순 알파벳출력한다
 * (3) 알파벳을 제외한 문자는 그대로 출력
 * **/
fun solution4(word: String): String {
    var solutionWord = "" //return 값

    val wordPiece = word.toList() //(1) 한 글자씩 분리

    for(index  in wordPiece.indices) {
        if (wordPiece[index].isUpperCase()) { //대문자 -> 역순알파벳찾아주기
            val reverseOrder = abs(wordPiece[index].code - 91) + 64
            solutionWord += reverseOrder.toChar()
            continue
        }

        if (wordPiece[index].isLowerCase()) { //소문자 -> 역순알파벳찾아주기
            val reverseOrder = abs(wordPiece[index].code - 123) + 96
            solutionWord += reverseOrder.toChar()
            continue
        }
    }

    return solutionWord
}
