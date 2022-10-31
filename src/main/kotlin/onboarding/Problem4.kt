package onboarding

fun solution4(word: String): String {
    var answer = ""

    for (i in 0..word.length) {
        var code = word[i].toInt()
        if (65<=code && code<=90) {answer.plus((155-code).toChar())}
        else if (97<=code && code<=122) {answer.plus((219-code).toChar())}
        else {answer.plus(word[i])}
    }

    return answer
}
