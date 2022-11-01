package onboarding

fun solution5(money: Int): List<Int> {

    val result = MutableList<Int>(9){0}

    result[0] = money / 50000
    result[1] = money % 50000 / 10000
    result[2] = money % 50000 % 10000 / 5000
    result[3] = money % 50000 % 10000 % 5000 / 1000
    result[4] = money % 50000 % 10000 % 5000 % 1000 / 500
    result[5] = money % 50000 % 10000 % 5000 % 1000 % 500 / 100
    result[6] = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 / 50
    result[7] = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 / 10
    result[8] = money % 50000 % 10000 % 5000 % 1000 % 500 % 100 % 50 % 10 / 1

    return result

}