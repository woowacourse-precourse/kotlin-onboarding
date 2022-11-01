package onboarding

fun solution5(money: Int): List<Int> {
    val pocket = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val result = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var nowMoney = money
    for (idx in pocket.indices) {
        result[idx] = categorizeForMoney(nowMoney, pocket, idx)
        nowMoney -= pocket[idx] * result[idx]
    }
    return result
}

fun categorizeForMoney(money: Int, pocket: List<Int>, idx: Int): Int {
    var cnt = 0
    var nowMoney = money
    while (true) {
        if (nowMoney - pocket[idx] >= 0) {
            nowMoney -= pocket[idx]
            ++cnt
            continue
        }
        break
    }
    return cnt
}