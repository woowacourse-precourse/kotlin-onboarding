package onboarding

fun solution5(money: Int): List<Int> {
    var _money: Int = money
    var count_list: ArrayList<Int> = arrayListOf(0,0,0,0,0,0,0,0,0)
    val MONEY_LIST: ArrayList<Int> = arrayListOf(50000,10000,5000,1000,500,100,50,10,1)

    for(i: Int in 0..count_list.size -1){
        if(_money >= MONEY_LIST[i]){
            count_list[i] = _money/MONEY_LIST[i]
            _money %= MONEY_LIST[i]
        }
    }

    return count_list
}