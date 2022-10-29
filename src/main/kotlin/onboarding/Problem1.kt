package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!checkException(pobi) || !checkException(crong)) {
        return -1
    }
    val pobi_num = compareLeftRight(pobi)
    val crong_num = compareLeftRight(crong)
    return match(pobi_num, crong_num)
}

fun checkException(pageNum: List<Int>): Boolean {
    return when ((pageNum[0] % 2 == 1) &&
            (pageNum[1] == pageNum[0] + 1) &&
            (pageNum[0] >= 3) &&
            (pageNum[0] <= 397)) {
        true -> true
        false -> false
    }
}

fun compareLeftRight(pageNum: List<Int>): Int {
    val left = calculateMax(pageNum[0])
    val right = calculateMax(pageNum[1])
    return when (left > right) {
        true -> left
        false -> right
    }
}

fun calculateMax(page: Int): Int {
    var num = page
    var sumAndProduct = mutableListOf<Int>(0, 1)
    do {
        sumAndProduct[0] += num % 10
        sumAndProduct[1] *= num % 10
        num /= 10
    } while (num > 0)
    return when (sumAndProduct[0] > sumAndProduct[1]) {
        true -> sumAndProduct[0]
        false -> sumAndProduct[1]
    }
}

fun match(pobi_num: Int, crong_num: Int): Int {
    return when (pobi_num - crong_num) {
        in 1..300 -> 1
        0 -> 0
        else -> 2
    }
}