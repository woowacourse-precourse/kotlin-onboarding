package onboarding

fun solution5(money: Int): List<Int> {
    val result = arrayListOf<Int>()
    var data = money
    val currencyKind = arrayOf(50000,10000,5000,1000,500,100,50,10,1)
    // 최소 화폐 개수를 위해 최대 가치 화폐 개수부터 구함.
    for (i in 0 .. 8){
        result.add( data / currencyKind[i] )
        data %= currencyKind[i]
    }
    return result
}
