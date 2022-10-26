package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    return if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1 || pobi[0] % 2 != 1 || pobi[1] % 2 != 0 || crong[0] % 2 != 1 || crong[1] % 2 != 0) {
        -1
    } else {
        val pobiMax = maxOf(pobi[0].getNumberList().sum(), pobi[0].getNumberList().multi(), pobi[1].getNumberList().sum(), pobi[1].getNumberList().multi())
        val crongMax = maxOf(crong[0].getNumberList().sum(), crong[0].getNumberList().multi(), crong[1].getNumberList().sum(), crong[1].getNumberList().multi())
        if (pobiMax > crongMax) 1
        else if (crongMax > pobiMax) 2
        else 0
    }
}

fun Int.getNumberList(): List<Int> = toString().map { it.digitToInt() }

fun List<Int>.multi() = reduce { acc, i -> acc * i }