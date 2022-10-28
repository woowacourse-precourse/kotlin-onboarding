package onboarding

val successiveCharRegex="""a{2,}|b{2,}|c{2,}|d{2,}|e{2,}|f{2,}|g{2,}|h{2,}|i{2,}|j{2,}|k{2,}|l{2,}|m{2,}|n{2,}|o{2,}|p{2,}|q{2,}|r{2,}|s{2,}|t{2,}|u{2,}|v{2,}|w{2,}|x{2,}|y{2,}|z{2,}""".toRegex()
fun solution2checkSuccessiveChar(word:String): Boolean {
    return successiveCharRegex.containsMatchIn(word)
}

fun solution2replaceSuccessiveChar(word:String): String{
    return word.replace(successiveCharRegex, "")
}

fun solution2(cryptogram: String): String {
    var resultString=cryptogram
    while(solution2checkSuccessiveChar(resultString)){
        resultString=solution2replaceSuccessiveChar(resultString)
    }

   return resultString
}
