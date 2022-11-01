package onboarding

private val digits = setOf('3', '6', '9')

fun solution3(number: Int): Int {
    return (1..number).sumOf { it.countOf(digits) }
}

private fun Int.countOf(numbers: Collection<Char>): Int {
    return toString().count { it in numbers }
}