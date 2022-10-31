package onboarding

fun solution5(money: Int): List<Int> {
    TODO("프로그램 구현")
    var N : Int = money
    val classification = intArrayOf(50000,10000,5000,1000,500,100,50,10,1)
    val result = mutableListOf<Int>()
    // 계산
    for(i in classification){
        result.add(N/i)
        N %= i
    }
    // println(result)
    return result
}
