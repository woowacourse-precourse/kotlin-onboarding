package onboarding

fun solution5(money: Int): List<Int> {
//    TODO("프로그램 구현")
    val money_unit:List<Int> = arrayListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    val money_count: MutableList<Int> = List(9) {0}.toMutableList()

    var m = money

    for (i in 0 .. 8){
        if (money >= money_unit[i]){
            val temp = m / money_unit[i]
            money_count[i] = temp
            m -= money_unit[i] * temp

        }
    }

    return money_count
}

