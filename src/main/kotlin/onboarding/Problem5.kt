package onboarding

private val MONEY_TYPE = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

fun solution5(money: Int): List<Int> {
    // 답을 표시할 IntArray 생성
    val moneyCount = money.calculator()
    return moneyCount.toList()
}

private fun Int.calculator(): IntArray {
    val tmp = IntArray(9) { 0 }
    var money = this
    // 5만원 단위부터 일원 단위까지 순서대로 나눈다
    MONEY_TYPE.forEachIndexed { index, i ->
        // 5만원으로 나눠지면 나눈값을 IntArray[0]에 넣는다.
        if(money/i != 0) {
            tmp[index] = money/i
        }
        money %= i
    }
    // IntArray반환
    return tmp
}
