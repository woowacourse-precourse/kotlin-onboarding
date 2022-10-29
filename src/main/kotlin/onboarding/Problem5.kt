package onboarding

fun solution5(money: Int): List<Int> {
    var result = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)

    return calcMoney(result, money)
}

fun calcMoney_50000(result: MutableList<Int>, money: Int): MutableList<Int> {
    result[0] = money / 50000

    return calcMoney_10000(result, money % 50000)
}

fun calcMoney_10000(result: MutableList<Int>, money: Int): MutableList<Int> {
    result[1] = money / 10000

    return calcMoney_5000(result, money % 10000)
}

fun calcMoney_5000(result: MutableList<Int>, money: Int): MutableList<Int> {
    result[2] = money / 5000

    return calcMoney_1000(result, money % 5000)
}

fun calcMoney_1000(result: MutableList<Int>, money: Int): MutableList<Int> {
    result[3] = money / 1000

    return calcMoney_500(result, money % 1000)
}

fun calcMoney_500(result: MutableList<Int>, money: Int): MutableList<Int> {
    result[4] = money / 500

    return calcMoney_100(result, money % 500)
}

fun calcMoney_100(result: MutableList<Int>, money: Int): MutableList<Int> {
    result[5] = money / 100

    return calcMoney_50(result, money % 100)
}

fun calcMoney_50(result: MutableList<Int>, money: Int): MutableList<Int> {
    result[6] = money / 50

    return calcMoney_10(result, money % 50)
}

fun calcMoney_10(result: MutableList<Int>, money: Int): MutableList<Int> {
    result[7] = money / 10

    return calcMoney_1(result, money % 10)
}

fun calcMoney_1(result: MutableList<Int>, money: Int): MutableList<Int> {
    result[8] = money
    return result
}

fun calcMoney(result: MutableList<Int>, money: Int): MutableList<Int> {
    return calcMoney_50000(result, money)
}
