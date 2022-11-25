package onboarding

private val priceList = mutableListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
fun solution5(money: Int): List<Int> {
    val resultList = mutableListOf<Int>()
    return loopExchange(money, resultList)
}

fun loopExchange(money : Int, resultList : MutableList<Int> ) : List<Int> {
    var mMoney = money
    for(i in priceList) {
        val mList = checkHowMuch(mMoney, i)
        resultList.add(mList.first) //위의 mList의 0번째에는 몫의 값, 즉 몇 번 바꿀 수 있는지가 들어간다. 그러므로 결과값을 리턴해줄 List에 추가한다.
        mMoney = mList.second // mList의 1번째에는 나머지 값, 즉 남은 금액이 들어가므로, 이를 활용해 다시 한번 루프를 돌리면 남은 금액에 그 다음번 필터가 몇 번 돌아갈지가 구해진다.
    }
    return resultList
}

/**
 * 현재 금액을 몇 번 바꿀 수 있는지, 바꾼 후 금액은 얼마인지 계산해주는 함수
 */
private fun checkHowMuch(price : Int, priceList : Int) : Pair<Int, Int> {
    return Pair(price / priceList, price % priceList) // 몫과 나머지 모두를 반환해줘야 하므로 Pair<Int, Int> 형 반환을 선택했다.
}

