package onboarding

fun solution5(money: Int): List<Int> {
    return calculateMoney(money)
}

fun calculateMoney(money: Int): MutableList<Int>{
    var m = money
    val cash = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val result = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)
    for(i in cash.indices){
        result[i] = m / cash[i]
        m %= cash[i]

        if(m == 0){
            break
        }
    }
    return result
}