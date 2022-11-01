package onboarding

fun solution5(money: Int): List<Int> {

    var inputMoney = money
    val moneyArray = arrayListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10,1)
    val resultArray = ArrayList<Int>()

    for (i in 0 until moneyArray.size) {
        val count = inputMoney / moneyArray[i]
        resultArray.add(count)
        inputMoney %= moneyArray[i]
    }

    return resultArray
}
