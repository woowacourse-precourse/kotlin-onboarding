package onboarding

fun checkException(pobi: List<Int>, crong: List<Int>): Boolean {
    val allPage = mutableListOf<Int>()
    allPage.addAll(pobi)
    allPage.addAll(crong)
    allPage.forEach { page ->
        if (page < 0 || page > 400) return false
    }
    if (pobi[0] + 1 != pobi[1] || crong[0] + 1 != crong[1] || pobi.size != 2 || crong.size != 2) {
        return false
    }
    //todo 책 페이지 0~400 준수 예외 작성
    return true
}

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (!checkException(pobi, crong)) return -1
    return compareResult(checkMaxValue(pobi), checkMaxValue(crong))
}

fun compareResult(pobiValue: Int, crongValue: Int): Int {
    when {
        pobiValue > crongValue -> return 1
        pobiValue < crongValue -> return 2
        pobiValue == crongValue -> return 0
    }
    return -1
}

fun addPage(list: List<Int>): Int {
    var max = 0
    for (item in list) {
        val sum = item.toString().toCharArray().sumOf { Character.getNumericValue(it) }
        max = max.coerceAtLeast(sum)
    }
    return max
}

fun multiplyPage(list: List<Int>): Int {
    var max = 0
    for (item in list) {
        var sum = 1
        item.toString().toCharArray().map { sum *= Character.getNumericValue(it) }
        max = max.coerceAtLeast(sum)
    }
    return max
}

fun checkMaxValue(list: List<Int>): Int {
    val addValue = addPage(list)
    val mulValue = multiplyPage(list)
    return addValue.coerceAtLeast(mulValue)
}