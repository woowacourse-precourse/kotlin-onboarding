package onboarding


fun checkSuccessiveChar(word:String, successiveCharRegex:Regex): Boolean {
    return successiveCharRegex.containsMatchIn(word)
}

fun replaceSuccessiveChar(word:String, successiveCharRegex:Regex): String{
    return word.replace(successiveCharRegex, "")
}

fun solution2(cryptogram: String): String {
    var resultString=cryptogram
    //연속해서 같은 문자(소문자 알파벳)이 포함되는 경우를 확인하기 위한 정규식
    val successiveCharRegex="""a{2,}|b{2,}|c{2,}|d{2,}|e{2,}|f{2,}|g{2,}|h{2,}|i{2,}|j{2,}|k{2,}|l{2,}|m{2,}|n{2,}|o{2,}|p{2,}|q{2,}|r{2,}|s{2,}|t{2,}|u{2,}|v{2,}|w{2,}|x{2,}|y{2,}|z{2,}""".toRegex()
    while(checkSuccessiveChar(resultString, successiveCharRegex)){
        resultString=replaceSuccessiveChar(resultString, successiveCharRegex)
    }

   return resultString
}
