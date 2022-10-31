package onboarding

fun solution4(word: String): String {
    var answer = ""

    for (i in 0..word.length-1) {
        val wrd:Char = word[i]
        val code = wrd.toInt()
        if (65<=code && code<=90) {answer = answer.plus((155-code).toChar())}
        else if (97<=code && code<=122) {answer = answer.plus((219-code).toChar())}
        else {answer = answer.plus(word[i])}
    }

    return answer
}
