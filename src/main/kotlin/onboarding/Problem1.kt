package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    fun getPageMax(page: Int): Int {
        var plusSum: Int = 0
        var mutlipleSum: Int = 1
        var page: Int = page

        while (page != 0) {
            plusSum = plusSum + (page % 10)
            mutlipleSum = mutlipleSum * (page % 10)
            page /= 10
        }

        if (plusSum < mutlipleSum) {
            return mutlipleSum
        }
        else
            return plusSum
    }

    fun getLeftRightMax(left: Int, right: Int): Int {
        var max: Int

        if (left < right) {
            max = right
        } else
            max = left

        return max
    }

    var pobiMax = getLeftRightMax(getPageMax(pobi[0]), getPageMax(pobi[1]))
    var crongMax = getLeftRightMax(getPageMax(crong[0]), getPageMax(crong[1]))

    if ((pobi[0] + 1 == pobi[1]) && (crong[0] + 1 == crong[1])) {
        if (pobiMax == crongMax) {
            return 0
        } else {
            if (pobiMax > crongMax) {
                return 1
            } else if (pobiMax < crongMax) {
                return 2
            } else
                return -1
        }
    } else
        return -1

}
