package onboarding

import java.lang.management.MonitorInfo

fun solution5(money: Int): List<Int> {
    var Result = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var Money_arr = listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)
    var Money = money

    for (i in 0..9){
        while (Money / Money_arr[i] != 0){
            Money -= Money_arr[i]
            Result[i]++
        }
    }

    return Result
}
