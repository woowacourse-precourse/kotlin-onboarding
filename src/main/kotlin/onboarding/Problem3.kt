package onboarding

fun solution3(number: Int): Int {
    val list = listOf(3, 6, 9)

    return (1..number).fold(0) { acc, num ->
        acc + num.toString().count { it.digitToInt() in list }
    }
}