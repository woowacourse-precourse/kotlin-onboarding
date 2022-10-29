package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (checkForExceptions(pobi) || checkForExceptions(crong))
        return -1

    val largestNumOfPobi = findTheLargestNumber(pobi)
    val largestNumOfCrong = findTheLargestNumber(crong)

    return when {
        largestNumOfPobi > largestNumOfCrong -> 1
        largestNumOfPobi < largestNumOfCrong -> 2
        else -> 0
    }
}

fun findTheLargestNumber(pageList: List<Int>) : Int {
    val calculatedNum = mutableListOf<Int>()
    calculatedNum.add(addValue(pageList[0]))
    calculatedNum.add(multiValue(pageList[0]))
    calculatedNum.add(addValue(pageList[1]))
    calculatedNum.add(multiValue(pageList[1]))
    return calculatedNum.maxOf { it }
}

fun multiValue(page: Int) : Int {
    var result = 1
    page.toString().forEach { c -> result *= (c - '0') }
    return result
}

fun addValue(page: Int) : Int {
    var result = 0
    page.toString().forEach { c -> result += (c - '0') }
    return result
}

fun checkForExceptions(page: List<Int>) : Boolean {
    return when (page[1] - page[0]) {
        1 -> false
        else -> true
    }
}