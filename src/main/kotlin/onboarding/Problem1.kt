package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {
    if (isException(pobi) || isException(crong)) {
        return -1
    }

    return getWinner(getMax(pobi), getMax(crong))
}

fun isException(list: List<Int>): Boolean{
    if (list[0]+1 != list[1]) {
        return true
    }
    if (list[0] <= 1 || list[1] >= 400) {
        return true
    }
    if (list[0]%2 == 0 || list[1]%2 == 1) {
        return true
    }

    return false
}

fun getMax(pages: List<Int>): Int{
    var list = mutableListOf<Int>()

    for (page in pages) {
        list.add(getSum(page))
        list.add(getMultiply(page))
    }

    return list.maxOf { it }
}

fun getSum(_num: Int): Int {
    var sum: Int = 0
    var num: Int = _num

    while (num > 0){
        sum += (num % 10)
        num /= 10
    }

    return sum
}

fun getMultiply(_num: Int): Int{
    var multiply: Int = 1
    var num: Int = _num

    while (num > 0){
        multiply *= (num % 10)
        num /= 10
    }

    return multiply
}

fun getWinner(pobiNum: Int, crongNum: Int): Int {
    if (pobiNum > crongNum)
        return 1
    if (pobiNum < crongNum)
        return 2

    return 0
}