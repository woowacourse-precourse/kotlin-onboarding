/*
* 기능 목록
* 1. 알파벳 변환
* 1-1. 문자열의 문자를 하나씩 검사하여 해당 문자가 대문자인지 소문자인지 확인한다.
* 1-2. 문자가 대문자라면, 대문자 범위를 합한 변수인 upperAlpha 를 char값으로 바꿔준 후 해당되는 문자를 빼주고 그 값을 char값으로 바꿔준다. (소문자도 같음)
* 1-3. 위의 과정이 끝나면 변환이 끝난 문자를 빈 문자열인 tmpString 에 붙여준다.
* 1-4. 알파벳이 아닌 문자라면 그냥 문자열에 붙여준다.
* */

package onboarding

fun convertAlpha(str : String) : String {
    var tmpString = ""

    var upperAlphaRange = 'A' .. 'Z'
    var lowerAlphaRange = 'a' .. 'z'

    var upperAlpha = 155    //65 + 90
    var lowerAlpha = 219    //97 + 122

    for(c in str) {
        if(c in upperAlphaRange) {
            tmpString += (upperAlpha.toChar() - c).toChar()
        }
        else if(c in lowerAlphaRange) {
            tmpString += (lowerAlpha.toChar() - c).toChar()
        }
        else tmpString += c
    }

    return tmpString
}
fun solution4(word: String): String {
//    TODO("프로그램 구현")
    var ans = word

    return convertAlpha(ans)
}