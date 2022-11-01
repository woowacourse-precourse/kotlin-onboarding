package onboarding

fun solution5(money: Int): List<Int> {
    var won = money
    val moneyUnit = listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)
    var moneyList = mutableListOf<Int>(0,0,0,0,0,0,0,0,0)

    for(i in moneyUnit.indices){
        if(won/moneyUnit[i]==0){
            continue
        }
        moneyList[i] = won / moneyUnit[i]
        won %= moneyUnit[i]
    }
    return moneyList
}
