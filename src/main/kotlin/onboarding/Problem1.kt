package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (checkForExceptions(pobi) == -1) return -1
    if (checkForExceptions(crong) == -1) return -1

    val p = findTheLargestNumber(pobi)
    val c = findTheLargestNumber(crong)

    return if (p > c) 1
    else if (p < c) 2
    else 0
}

fun findTheLargestNumber(pageList: List<Int>) : Int {
    var result = 0

    var temp = addValue(pageList[0])
    result = temp

    temp = multiValue(pageList[1])
    if (result < temp) result = temp

    temp = addValue(pageList[1])
    if (result < temp) result = temp

    temp = multiValue(pageList[0])
    if (result < temp) result = temp

    return result
}

fun multiValue(page: Int) : Int {
    var result = 1
    val page : String = page.toString()
    page.forEach { c ->
        result *= (c - '0')
    }
    return result
}

fun addValue(page: Int) : Int {
    var result = 0
    val page : String = page.toString()

    page.forEach { c ->
        result += (c - '0')
    }

    return result
}


fun checkForExceptions(page: List<Int>) : Int{
    if (page.size != 2) return -1
    if (page[1] - page[0] != 1) return -1

    return 0
}

fun main() {
    println(solution1(listOf(97, 98), listOf(197, 198)))
    println(solution1(listOf(131, 132), listOf(211, 212)))
    println(solution1(listOf(99, 102), listOf(211, 212)))
}