package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (pobi.size != 2 || crong.size != 2) {
        return -1;
    }

    return if (pobi[1] - pobi[0] == 1 && crong[1] - crong[0] == 1) {
        val pbNum = choice(calculate(pobi[0]), calculate(pobi[1]))
        val crNum = choice(calculate(crong[0]), calculate(crong[1]))
        win(pbNum, crNum)

    } else -1

}

fun calculate(num: Int): Int {
    val a = num.toString().map {
        it.code - '0'.code
    }.sum()
    val b = num.toString().map {
        it.code - '0'.code
    }.mul()
    return if (a > b) a else b
}

fun Iterable<Int>.mul(): Int {
    var mul = 1
    for (element in this) {

        if (element == 0) return 0
        mul *= element
    }
    return mul

}


fun choice(num1: Int, num2: Int): Int {
    return if (num1 > num2) num1 else num2

}

fun win(num1: Int, num2: Int): Int {
    return if (num1 > num2) 1
    else if (num1 < num2) 2
    else 0

}