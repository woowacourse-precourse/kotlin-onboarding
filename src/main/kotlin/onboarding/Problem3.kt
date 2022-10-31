package onboarding

fun solution3(number: Int): Int {
    val list = listOf('3', '6', '9')
    var result = 0
    for (n in 1..number) {
        result += list.sumOf { c ->
            n.toString().count { it == c }
        }
    }
    return result
}