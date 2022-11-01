package onboarding

private val numberSet = setOf(3, 6, 9)

fun solution3(number: Int): Int {
    return (1..number).fold(0) { acc, num ->
        acc + num.countOf(numberSet)
    }
}

private fun Int.countOf(numbers: Collection<Int>): Int {
    return toString().count { it.digitToInt() in numbers }
}