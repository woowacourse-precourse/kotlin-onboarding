package onboarding

import java.lang.management.MonitorInfo
import java.time.Month

fun solution5(money: Int): List<Int> {
    val Result = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var Money_arr = mutableListOf(50000,10000,5000,1000,500,100,50,10,1)
    var Money = money

//    for (i in 0..8){
//        if (Money >= Money_arr[i]){
//            Result[i] = Money / Money_arr[i]
//            Money -= Money_arr[i] * Result[i]
//        }
//    }

//    for (i in 0..8){
//        while (Money / Money_arr[i] > 0){
//            Money -= Money_arr[i]
//            Result[i]++
//        }
//    }

    //foreach는 해당 값을 그대로 가져온다
    //여기서 사용할라면 이렇게 사용해야될듯 그냥 for쓰자

    var i = 0
    Money_arr.forEach{

        while (Money / it > 0){
            Money -= it
            Result[i]++
        }
        i++
    }

    return Result.toList()
}
