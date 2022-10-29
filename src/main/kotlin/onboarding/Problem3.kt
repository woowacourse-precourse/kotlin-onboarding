package onboarding

fun main(args: Array<String>) {
    println(solution3(33))
}

fun solution3(number: Int): Int {
    return countClabNumber(number = number)
}

fun countClabNumber(number: Int): Int {
    val targetNumbers = listOf('3', '6', '9')
    var clabNumber = 0

    repeat(number) { curNumber ->
        clabNumber += curNumber.toString().count {
            targetNumbers.contains(it)
        }
    }

    return clabNumber
}

