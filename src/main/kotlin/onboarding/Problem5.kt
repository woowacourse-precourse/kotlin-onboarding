package onboarding

fun solution5(money: Int): List<Int> {
    var rest = money
    var unitList  = mutableListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1) // unit
    var moneyList = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0) //money list

    for (index in 0..8){
        while (rest >= unitList[index]){
            rest -= unitList[index] // rested money
            moneyList[index] += 1 // add money
        }
    }
    return moneyList
}
