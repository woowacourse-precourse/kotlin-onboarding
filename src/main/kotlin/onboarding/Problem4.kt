package onboarding

fun solution4(word: String): String {
    TODO("프로그램 구현")
    var answer = word
    for (i in 0 until word.length) {
        if (word[i].toInt() in 97 .. 122) answer = answer.substring(0, i) + (219-word[i].toInt()).toChar() + answer.substring(i+1)
        else if (word[i].toInt() in 65 .. 90) answer = answer.substring(0, i) + (155-word[i].toInt()).toChar() + answer.substring(i+1)
    }
    return answer
}
