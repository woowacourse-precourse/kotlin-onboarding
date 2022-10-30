package onboarding

fun solution5(money: Int): List<Int> {
    var moneyList = mutableListOf(0,0,0,0,0,0,0,0,0)
    var money = money

    //제한사항 위반 사례 처리
    if (money < 1 || money > 1000000){
        return moneyList
    }

}
