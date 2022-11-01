package onboarding

fun solution5(money: Int): List<Int> {
    var money:Int = money
    var result = mutableListOf<Int>()
    val moneyList = listOf(50000,10000,5000,1000,500,100,50,10,1)

    for(i in moneyList){
        //각 돈의 단위가 얼마나 필요한지 계산함
        result.add(money/i)
        //money update
        money -= (money/i)*i
    }
    return result
}
