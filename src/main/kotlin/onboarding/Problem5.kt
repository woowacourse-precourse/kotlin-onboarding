package onboarding

fun solution5(money: Int): List<Int> {
    //TODO("프로그램 구현")
    var currentMoney = money
    var result = mutableListOf<Int>(0,0,0,0,0,0,0,0,0)
    val change = arrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    var j = 0
    for (i : Int in change) {
        var value = currentMoney / i
        if (value != 0) {
            result[j] = value
            currentMoney -= value * i
        }
        j++
    }
    return result.toList()
}