package onboarding

/*
기능항목 정리
1. 큰 지페 순서대로 얼마나 필요한지 구하기
2. 큰 지페 순서대로 리스트에 담기
 */
fun solution5(money: Int): List<Int> {
    var currentAmount = money
    var count: Int
    val currencyTypeList = arrayOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val currencyCountList = arrayListOf<Int>()

    currencyTypeList.forEach { currencyType ->
        count = currentAmount / currencyType
        currencyCountList.add(count)
        currentAmount -= currencyType * count
    }

    return currencyCountList.toList()
}

