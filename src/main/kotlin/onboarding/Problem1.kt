package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobiMax = getLeftRightMax(getPageMax(pobi[0]), getPageMax(pobi[1]))
    var crongMax = getLeftRightMax(getPageMax(crong[0]), getPageMax(crong[1]))

    return if ((pobi[0] + 1 == pobi[1]) && (crong[0] + 1 == crong[1])) {
        if (pobiMax == crongMax) {
            0
        } else {
            if (pobiMax > crongMax) {
                1
            } else if (pobiMax < crongMax) {
                2
            } else
                -1
        }
    } else
        -1
}

fun getPageMax(page: Int): Int {
    var plusSum: Int = 0
    var mutlipleSum: Int = 1
    var page: Int = page

    while (page != 0) {
        plusSum += (page % 10)
        mutlipleSum *= (page % 10)
        page /= 10
    }

    return if (plusSum < mutlipleSum) {
        mutlipleSum
    } else
        plusSum
}

fun getLeftRightMax(left: Int, right: Int): Int {

    var max: Int = if (left < right) {
        right
    } else
        left

    return max
}