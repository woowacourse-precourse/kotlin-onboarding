package onboarding

fun solution5(money: Int): List<Int> {
    val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val result = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var value = money
    for (idx in moneyList.indices) {
        while (true) {
            if (value - moneyList[idx] >= 0) {
                value -= moneyList[idx]
                ++result[idx]
                continue
            }
            break
        }
    }
    return result
}

fun main() {
    //오마넌 , 마넌, 오처넌, 처넌, 오백원, 백원, 오십원, 십원
    println(solution5(15000))
}
