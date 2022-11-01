package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (checkException(pobi) && checkException(crong)) {
        val pobiScore = getScore(pobi)
        val crongScore = getScore(crong)

        if (pobiScore > crongScore)
            return 1
        if (pobiScore < crongScore)
            return 2
        return 0

    }
    return -1
}

fun checkException(pages: List<Int>): Boolean {
    return (pages[0] + 1) == pages[1]
}

fun getScore(pages: List<Int>): Int {
    var res = 0
    for (page in pages) {
        res = getMaxScore(getMaxScore(addPage(page), multiplyPage(page)), res)
    }
    return res
}

fun getMaxScore(a: Int, b: Int): Int {
    if (a > b)
        return a
    return b
}

fun addPage(page: Int): Int {
    var num = page
    var res = 0
    while (num > 0) {
        res += num % 10
        num /= 10
    }
    return res
}

fun multiplyPage(page: Int): Int {
    var num = page
    var res = 1
    while (num > 0) {
        res *= num % 10
        num /= 10
    }
    return res
}