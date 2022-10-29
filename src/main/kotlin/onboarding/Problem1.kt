package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    var pobiMax: Int = 0
    var crongMax: Int = 0

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

    return 0
}
