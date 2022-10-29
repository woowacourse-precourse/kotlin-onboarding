package onboarding

fun main(args: Array<String>) {
    println(solution3(33))
}

fun solution3(number: Int): Int {

}

fun isTargetNumber(num: Int): Boolean {
    val targetNumbers = intArrayOf(3, 6, 9)

    targetNumbers.forEach { targetNum ->
        if (num.toString().contains(targetNum.toString())) return true
    }
    return false
}

