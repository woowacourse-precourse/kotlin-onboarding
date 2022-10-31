package onboarding

fun findIdx(num: Int): Int { // 최대로 뺄 수 있는 값의 idx를 return
    val moneyRange = arrayListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    for (idx in 0 until moneyRange.size){
        if (num - moneyRange[idx] >= 0) return idx
    }
    return -1
}

fun solution5(money: Int): List<Int> {
    val bills = arrayListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)
    val moneyRange = arrayListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    var nowMoney = money
    while (nowMoney > 0) {
        val idx = findIdx(nowMoney)
        nowMoney -= moneyRange[idx]
        bills[idx] += 1
    }
    return bills
}