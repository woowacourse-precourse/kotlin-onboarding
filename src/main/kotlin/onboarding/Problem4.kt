package onboarding

import java.util.*

fun solution4(word: String): String {
    var ascii = 'Z'
    //A B C ..
    //Z Y X .. 과 같이 mapping 시키기 위한 배열
    val mappingRecord = Array(26) { ascii-- }

    //대문자를 기준으로 mapping된 배열을 만들었기 때문에 word를 모두 대문자로 바꾼 string을 선언
    val upperWord = word.uppercase(Locale.getDefault())
    var resultString = ""

    for (index in word.indices) {
        if (word[index] == ' ') {
            resultString += ' '
            continue
        }
        val appendChar = mappingRecord[upperWord[index].code - 'A'.code]

        //input에서 해당 인덱스의 문자가 소문자인 경우는 소문자로 바꾸기
        resultString += if (word[index].isUpperCase()){
            appendChar
        }
        else{
            appendChar.lowercaseChar()
        }
    }

    return resultString
}
