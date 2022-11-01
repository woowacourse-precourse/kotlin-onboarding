package onboarding

fun solution5(money: Int): List<Int> {
    var currentMoney = money
    val result = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)

    if (currentMoney >= 50000) {
        result[0] = currentMoney / 50000
        currentMoney -= 50000 * result[0]
    }
    if (currentMoney >= 10000) {
        result[1] = currentMoney / 10000
        currentMoney -= 10000 * result[1]
    }
    if (currentMoney >= 5000) {
        result[2] = currentMoney / 5000
        currentMoney -= 5000 * result[2]
    }
    if (currentMoney >= 1000) {
        result[3] = currentMoney / 1000
        currentMoney -= 1000 * result[3]
    }
    if (currentMoney >= 500) {
        result[4] = currentMoney / 500
        currentMoney -= 500 * result[4]
    }
    if (currentMoney >= 100) {
        result[5] = currentMoney / 100
        currentMoney -= 100 * result[5]
    }
    if (currentMoney >= 50) {
        result[6] = currentMoney / 50
        currentMoney -= 50 * result[6]
    }
    if (currentMoney >= 10) {
        result[7] = currentMoney / 10
        currentMoney -= 10 * result[7]
    }
    result[8] = currentMoney

    return result.toList()
}
