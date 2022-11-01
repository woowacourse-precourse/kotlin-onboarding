package onboarding

fun solution4(word: String): String {
    var result = ""
    for (str in word) {
        result += when (str.code) {
            in 97..122 -> {
                (219 - str.code).toChar()
            }
            in 65..90 -> {
                (155 - str.code).toChar()
            }
            32 -> ' '
            else -> str
        }
    }
    return result
}

//fun main() {
//    //소문자 합 219
//    //대문자 합 155
//    //공백 32
//    println(solution4("I love you"))
//    println(solution4("R olev blf"))
//}
