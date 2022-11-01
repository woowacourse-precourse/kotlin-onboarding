package onboarding

fun solution5(money: Int): List<Int> {
    var a = money
    var arr = arrayListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var arr1 = arrayListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)

    for (i in 0..8){
        while (a >= arr[i]){
            a -= arr[i]
            arr1[i]++
        }
    }
    return arr1
}
