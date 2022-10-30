package onboarding

/* TODO 기능 목록
*   - 알파벳 소문자 <-> 대문자 변경
*   - 문자열 역순으로 변경 */

fun solution4(word: String): String {
    var result = ""
    for(i in word){
        if(i.isUpperCase()){
            result=result.plus((27-((i
                .uppercaseChar().code)-64)+64)
                .toChar().toString())
        }
        else if(i.isLowerCase()){
            result=result.plus((27-((i.lowercaseChar().code)-96)+96).toChar().toString())
        }
        else if(!i.isLowerCase() && !i.isUpperCase()){
            result=result.plus(i)
        }
    }
    return result
}
