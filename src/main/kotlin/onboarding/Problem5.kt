package onboarding

fun solution5(money: Int): List<Int> {
    var temp = money
    var pocket = arrayListOf(0 ,0 ,0 ,0 ,0 ,0 ,0 ,0 ,0)
    val dollar = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    var count = 0
    for(i in dollar){
        pocket[count] += temp/dollar[count]
        temp %= dollar[count]
        count++
    }

    return pocket
}
