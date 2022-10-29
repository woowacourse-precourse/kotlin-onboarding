package onboarding

import kotlin.math.max

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    val pobiNum: Int
    val crongNum: Int

    if (isException(pobi) || isException(crong)) {
        return -1
    }

    pobiNum = getMax(pobi)
    crongNum = getMax(crong)

    return answer(pobiNum, crongNum)
}

fun isException(list: List<Int>): Boolean{
    if (list[0]+1 != list[1]) {
        return true
    }
    if (list[0] <= 1 || list[1] >= 400) {
        return true
    }
    if (list[0]%2 == 0 || list[1]%2 == 1) {
        return true
    }

    return false
}

fun getMax(pages: List<Int>): Int{
    var list = mutableListOf<Int>()

    for (page in pages) {
        list.add(getSum(page))
        list.add(getMultiply(page))
    }

    return list.maxOf { it }
}

fun getSum(x: Int): Int {
    var sum: Int = 0
    var numX: Int = x

    while (numX > 0){
        sum += (numX % 10)
        numX /= 10
    }
    return sum
}

fun getMultiply(x: Int): Int{
    var multiply: Int = 1
    var numX: Int = x

    while (numX > 0){
        multiply *= (numX % 10)
        numX /= 10
    }
    return multiply
}

fun answer(pobiNum: Int, crongNum: Int): Int {
    if (pobiNum > crongNum)
        return 1
    if (pobiNum < crongNum)
        return 2
    return 0
}