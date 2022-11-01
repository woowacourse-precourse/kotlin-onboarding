package onboarding

fun solution5(money: Int): List<Int> {
    return getMoneyUnitList(money)
}

fun getMoneyUnitList(money: Int): List<Int>{
    val moneyUnit: List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var resultList: MutableList<Int> = MutableList(9){0}
    var currMoney = money

    while (currMoney > 0){
        for(i in moneyUnit.indices){
            while (currMoney / moneyUnit[i] > 0){
                currMoney -= moneyUnit[i]
                resultList[i]++
            }
        }
    }

    return resultList
}
