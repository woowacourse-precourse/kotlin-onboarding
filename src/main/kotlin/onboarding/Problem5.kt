package onboarding

fun solution5(money: Int): List<Int> {
    var currentMoney = money
    var result = mutableListOf<Int>()
    var moneyUnits = listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)
    for(i in 0..8){
        result.add(currentMoney/moneyUnits[i])
        currentMoney%=moneyUnits[i]
    }
    return result
}
