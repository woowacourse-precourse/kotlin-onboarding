package onboarding

fun solution5(money: Int): List<Int> {
    TODO("프로그램 구현")
    var Result = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var Money_arr = listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)

    for (i in 0..9){
        while (money / Money_arr[i] != 0){
            money -= Money_arr[i]
            Result[i]++
        }
    }

    return Result
}
