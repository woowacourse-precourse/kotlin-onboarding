package onboarding

/*
[   0   ,   1  ,    2   ,  3   ,    4    ,   5    ,  6      ,    7   ,  8    ]
[오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전]
 */
fun solution5(money: Int): List<Int> {
    // mutable로 money를 대신할 값
    var mutableMoney = money
    // 금액을 표시할 리스트
    val currency = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var moneyCount = mutableListOf(0,0,0,0,0,0,0,0,0)

    for (i in 0 .. currency.size-1){
        // 금액을 하나씩 나누며 몇 장/개가 필요한지 업데이트
        val count:Int = mutableMoney / currency[i]
        moneyCount[i] = count

        // 돈 값 업데이트
        mutableMoney -= currency[i] * count
    }

    return moneyCount
}
