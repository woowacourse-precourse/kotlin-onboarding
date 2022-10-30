package onboarding

fun solution5(money: Int): List<Int> {
    var rest = money
    var unitList  = mutableListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var moneyList = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)

    for (index in 0..8){
        println(index)
        while (rest >= unitList[index]){
            rest -= unitList[index]
            moneyList[index] += 1
        }
    }
    return moneyList
}
