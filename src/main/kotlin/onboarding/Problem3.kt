package onboarding

fun solution3(number: Int): Int {
    val list = arrayListOf(3, 6, 9)

    return (0 ..  number).reduce() { acc, number ->
        acc + number.toString().count {
            it.digitToInt() in list
        }
    }
}