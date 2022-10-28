package onboarding

private val priceList = mutableListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
fun solution5(money: Int): List<Int> {
    val resultList = mutableListOf<Int>()
    var mMoney = money // 파라미터로 들어오는 변수는 val 이므로, 루프마다 값을 변경해주기 위해 var로 재선언했다.
    for(i in priceList) {
        val mList = checkHowMuch(mMoney, i)
        resultList.add(resultList[0])
        mMoney = mList[1]
    }
}

private fun checkHowMuch(price : Int, priceList : Int) : List<Int> {
    return listOf(price / priceList, price % priceList)
}

