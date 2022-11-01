package onboarding

fun solution5(money: Int): List<Int> {
    val coins : Array<Int> = arrayOf(50000, 10000,
            5000, 1000, 500,100,50,10,1)

    var values : Array<Int> = arrayOf(0,0,
            0, 0 ,0 ,0 , 0, 0, 0)

    var tmp = money

    for(i in 0.. 8){
        values[i] = tmp / coins[i]
        tmp -= coins[i] * values[i]
    }

    return values.toList()
}
