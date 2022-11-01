package onboarding

fun solution5(money: Int): List<Int> {
    var unit = 50000
    var balance = money
    var turn = true
    val list = mutableListOf<Int>()
    val totalUnit=9
    while (balance > 0) {
        list.add(balance / unit)
        balance %= unit

        unit /= if (turn) {
            5
        } else if (unit == 10) {
            list.add(balance % unit)
            break
        } else 2
        turn = !turn
    }
    if (list.size < 10) {
        for (i in list.size until totalUnit)
            list.add(0)
    }
    return list
}
