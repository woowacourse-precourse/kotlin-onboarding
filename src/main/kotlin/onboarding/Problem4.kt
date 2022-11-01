package onboarding

fun solution4(word: String): String {
    val flog = mutableMapOf<String, String>()

    for (i in 0..25) {
        flog[('a' + i).toString()] = ('z' - i).toString()
        flog[('A' + i).toString()] = ('Z' - i).toString()
    }
    print(flog)
    return ""
}
fun main(){
    val word = "I love you"
    val result = "R olev blf"
    print(solution4(word).equals(result))
}
