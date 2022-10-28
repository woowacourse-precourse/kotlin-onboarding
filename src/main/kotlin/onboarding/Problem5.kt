package onboarding


fun solution5(money: Int): List<Int> {
    val won = listOf(50000,10000,5000,1000,500,100,50,10,1)
    val result : ArrayList<Int> = arrayListOf()
    var temp = money

    for(i in won){
        result.add(temp % i)
        temp /= i
    }

    return result
}