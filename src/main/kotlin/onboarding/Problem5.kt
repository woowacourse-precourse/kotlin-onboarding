package onboarding

fun solution5(money: Int): List<Int> {
    val result : Array<Int> = arrayOf(0,0,0,0,0,0,0,0,0)
    var index : Int = 0
    var money_copy : Int  = money
    for (i in arrayOf(50000,10000,5000,1000,500,100,50,10,1)){
        result[index] = money_copy/i
        money_copy -= i * result[index]
        if (money_copy == 0)
            break
        index++
    }
    return result.toList()
}
