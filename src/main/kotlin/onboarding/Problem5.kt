package onboarding

/*
기능 목록
- 화폐 단위에 맞게 츌금
- 출금된 단위에 맞게 배열에 저장
*/

fun withdrawMoney(money: Int, unit: Int): Int {
    return if (money >= unit)
        money % unit
    else
        -1
}

fun processMoney(money: Int): List<Int> {
    val units = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val r = MutableList(9) { 0 }
    var temporalMoney = money
    for (i in units.indices) {
        println(temporalMoney)
        var balance = withdrawMoney(temporalMoney, units[i])
        if (balance == -1)
            continue
        r[i] = temporalMoney / units[i]
        temporalMoney = balance
    }
    return r
}

fun solution5(money: Int): List<Int> {
    return processMoney(money)
}
