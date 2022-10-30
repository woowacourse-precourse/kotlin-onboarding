/*
* 기능 목록
* 1. 알파벳 변환
* 1-1. 문자열의 문자를 하나씩 검사하여 해당 문자가 대문자인지 소문자인지 확인한다.
* 1-2. 문자가 대문자라면, Z - (해당문자 - 'A') 를 해준다. (소문자도 동일한 방식으로 진행)
* 1-3. 위의 과정이 끝나면 변환이 끝난 문자를 빈 문자열인 tmpString 에 붙여준다.
* 1-4. 알파벳이 아닌 문자라면 그냥 문자열에 붙여준다.
* */

package onboarding

fun convertAlpha(str : String) : String {
    var tmpString = ""

    var upperAlphaRange = 'A' .. 'Z'
    var lowerAlphaRange = 'a' .. 'z'

    for(c in str) {
        if(c in upperAlphaRange) {
            tmpString += 'Z' - (c - 'A')
        }
        else if(c in lowerAlphaRange) {
            tmpString += 'z' - (c - 'a')
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