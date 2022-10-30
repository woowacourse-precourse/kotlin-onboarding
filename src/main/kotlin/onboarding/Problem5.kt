package onboarding

private var currentMoney = 0
private var result = mutableListOf<Int>()
private var moneyUnits = listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)
fun solution5(money: Int): List<Int> {
    currentMoney = money
    filterMoney()
    return result
}
private fun filterMoney(){
    for(i in 0..8){
        result.add(currentMoney/moneyUnits[i])
        getCurrentMoney(i)
    }
}
private fun getCurrentMoney(index : Int){

}
