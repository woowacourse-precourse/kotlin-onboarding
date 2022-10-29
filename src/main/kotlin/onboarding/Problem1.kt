package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!checkException(pobi) || !checkException(crong)) {
        return -1
    }
    val pobi_num = calculate(pobi)
    val crong_num = calculate(crong)
    return match(pobi_num, crong_num)
}

fun checkException(list: List<Int>): Boolean {
    return when ((list[0] % 2 == 1) &&
            (list[1] == list[0] + 1) &&
            (list[0] >= 3) &&
            (list[0] <= 397)) {
        true -> true
        false -> false
    }
}

fun calculate(list: List<Int>): Int {
    val left = calculate2(list[0])
    val right = calculate2(list[1])
    return when (left > right) {
        true -> left
        false -> right
    }
}

fun calculate2(par_num: Int): Int {
    var num = par_num
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