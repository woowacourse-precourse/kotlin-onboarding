package onboarding

fun main() {
    println(solution1(listOf(97, 98), listOf(197, 198)))
    println(solution1(listOf(131, 132), listOf(211, 212)))
    println(solution1(listOf(99, 102), listOf(211, 212)))
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi[0] + 1 != pobi[1] || crong[0] + 1 != crong[1]) return -1

    val pobiScore = getScore(pobi)
    val crongScore = getScore(crong)

    return when {
        pobiScore == crongScore -> 0
        pobiScore > crongScore -> 1
        pobiScore < crongScore -> 2
        else -> -1
    }
}

private fun getScore(pages: List<Int>): Int {
    val leftNums = pages[0].toString().toCharArray().map { it.digitToInt() }
    val rightNums = pages[1].toString().toCharArray().map { it.digitToInt() }

    val leftSum = leftNums.sum()
    val rightSum = rightNums.sum()

    var leftProduct = 1
    var rightProduct = 1

    leftNums.forEach { leftProduct *= it }
    rightNums.forEach { rightProduct *= it }

    return maxOf(leftSum, rightSum, leftProduct, rightProduct)
}
