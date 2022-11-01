package onboarding

fun solution5(money: Int): List<Int> {
    var mutableMoney = money
    val  moneysList = listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)
    val  countList= mutableListOf<Int>()
    for(i in moneysList.indices){
        var num:Int =mutableMoney/moneysList[i]
        mutableMoney %= moneysList[i]
        countList.add(num)
    }
    return countList
}
