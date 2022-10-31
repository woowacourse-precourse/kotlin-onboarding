package onboarding

fun solution4(word: String): String {
    val lowerAsciiSum = 'a'.code + 'z'.code
    val upperAsciiSum = 'A'.code + 'Z'.code
    var resultWord = ""

    for(i in word.indices){
        resultWord = when {
            word[i].isLowerCase() -> {
                resultWord.plus((lowerAsciiSum - word[i].code).toChar())
            }
            word[i].isUpperCase() -> {
                resultWord.plus((upperAsciiSum - word[i].code).toChar())
            }
            else -> {
                resultWord.plus(" ")
            }
        }
    }

    return resultWord
}
