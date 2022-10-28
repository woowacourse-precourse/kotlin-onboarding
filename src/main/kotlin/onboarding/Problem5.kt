package onboarding

fun solution5(money: Int): List<Int> {
    val result = ArrayList<Int>()
    var moneyInAccount=money
    val cashList :ArrayList <Int> = arrayListOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (cash in cashList){

        result.add(moneyInAccount/cash)
        moneyInAccount -= cash * (moneyInAccount/cash)

    }
    return result
}
