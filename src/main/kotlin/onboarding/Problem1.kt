package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!exceptionCheck(pobi) || !exceptionCheck(crong)) return -1

    var pobiNum = maxNum(pobi)
    var crongNum = maxNum(crong)

    return if (pobiNum > crongNum) 1
    else if (pobiNum < crongNum) 2
    else 0
}

fun exceptionCheck(list: List<Int>): Boolean {
    return list[0] % 2 == 1
            && list[1] % 2 == 0
            && list[1] - list[0] == 1
            && list[0] in 1..400
            && list[1] in 1..400
}

fun maxNum(list: List<Int>): Int {
    var maxNum = 0
    list.forEach {
        var page = it
        var sum = 0
        var mul = 1
        while (page > 0) {
            sum += page % 10
            mul *= page % 10
            page /= 10
        }
        val max = Math.max(sum, mul)
        maxNum = Math.max(maxNum, max)
    }
    return maxNum
}
