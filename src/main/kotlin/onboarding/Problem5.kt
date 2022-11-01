package onboarding

fun solution5(money: Int): List<Int> {
    val accountList :List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var coinList : MutableList<Int> = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var varMoney :Int = money

    for(index in accountList.indices) {
        coinList[index] = varMoney/accountList[index]
        varMoney %= accountList[index]
        if(varMoney == 0) {
            break
        }
    }
    return coinList
}