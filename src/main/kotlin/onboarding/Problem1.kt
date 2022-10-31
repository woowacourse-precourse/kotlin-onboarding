package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pPageLeft = pobi[0]
    val pPageRight = pobi[1]
    val cPageLeft = crong[0]
    val cPageRight = crong[1]

    if (isCorrect(pobi, pPageLeft, pPageRight) && isCorrect(crong, cPageLeft, cPageRight)) {
        val pSumOfPageLeft = addNumberOfDigit(pPageLeft)
        val pSumOfPageRight = addNumberOfDigit(pPageRight)
        val cSumOfPageLeft = addNumberOfDigit(cPageLeft)
        val cSumOfPageRight = addNumberOfDigit(cPageRight)

        val pMultipleOfPageLeft = multiplyNumberOfDigit(pPageLeft)
        val pMultipleOfPageRight = multiplyNumberOfDigit(pPageRight)
        val cMultipleOfPageLeft = multiplyNumberOfDigit(cPageLeft)
        val cMultipleOfPageRight = multiplyNumberOfDigit(cPageRight)

        val pMaxValue = max(max(pSumOfPageLeft, pMultipleOfPageLeft), max(pSumOfPageRight, pMultipleOfPageRight))
        val cMaxValue = max(max(cSumOfPageLeft, cMultipleOfPageLeft), max(cSumOfPageRight, cMultipleOfPageRight))

        return if (pMaxValue > cMaxValue) 1
        else if (pMaxValue < cMaxValue) 2
        else 0
    }
    else return -1
}

fun isCorrect(list: List<Int>, pageLeft: Int, pageRight: Int): Boolean {
    val condition1 = list.size == 2
    val condition2 = (pageLeft in 1..400 && pageRight in 1..400)
    val condition3 = (pageLeft % 2 == 1) && (pageRight % 2 == 0)
    val condition4 = pageRight - pageLeft == 1

    return condition1 && condition2 && condition3 && condition4
}

fun addNumberOfDigit(num: Int): Int {
    var number = num
    var sum = 0
    while (number != 0) {
        sum += (number % 10)
        number /= 10
    }
    return sum
}

fun multiplyNumberOfDigit(num: Int): Int {
    var number = num
    var multiple = 1
    while (number != 0) {
        multiple *= (number % 10)
        number /= 10
    }
    return multiple
}

fun max(num1: Int, num2: Int): Int = if (num1 > num2) num1 else num2

