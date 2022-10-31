package onboarding

fun solution4(word: String): String {
    var answer = ""

    for (i in word.indices)
        answer += convertAlphabet(word[i])
    return answer
}
fun convertAlphabet(alphabet: Char): Char{
    if (alphabet.isUpperCase())
        return (155-alphabet.code).toChar()
    if (alphabet.isLowerCase())
        return (219-alphabet.code).toChar()
    return alphabet
}
