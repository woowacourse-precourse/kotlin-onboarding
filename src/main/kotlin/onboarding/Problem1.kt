package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    // 코틀린의 리스트는 기본적으로 immutable임. 때문에 값 수정이 불가능함.
    var pobiMaxValue = 0
    var crongMaxValue = 0

    if (!isValidPageList(pobi[0], pobi[1]) ||
        !isValidPageList(crong[0], crong[1])
    ) {
        return -1
    }

    for (i in 0..1) {
        var temp = sumDigitValue(pobi[i])
        if (temp > pobiMaxValue) {
            pobiMaxValue = temp
        }
        temp = multiplyDigitValue(pobi[i])
        if (temp > pobiMaxValue) {
            pobiMaxValue = temp
        }
    }

    for (i in 0..1) {
        var temp = sumDigitValue(crong[i])
        if (temp > crongMaxValue) {
            crongMaxValue = temp
        }
        temp = multiplyDigitValue(crong[i])
        if (temp > crongMaxValue) {
            crongMaxValue = temp
        }
    }

    if (pobiMaxValue > crongMaxValue) {
        return 1
    } else if (pobiMaxValue < crongMaxValue) {
        return 2
    } else {
        return 0
    }

}

fun isValidPageList(left: Int, right: Int): Boolean {
    if (left + 1 == right && left % 2 == 1 && right % 2 == 0 && left >= 1 && left <= 400 && right >= 1 && right <= 400) {
        return true
    } else
        return false
}

fun sumDigitValue(pageNum: Int): Int {
    var sum = 0
    var pNum = pageNum
    while (pNum != 0) {
        sum += pNum % 10
        pNum /= 10
    }
    return sum
}

fun multiplyDigitValue(pageNum: Int): Int {
    var multiplyValue = 1
    var pNum = pageNum
    while (pNum != 0) {
        multiplyValue *= pNum % 10
        pNum /= 10
    }
    return multiplyValue
}
