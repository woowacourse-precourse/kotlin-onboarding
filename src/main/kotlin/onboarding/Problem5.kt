package onboarding

fun solution5(money: Int): List<Int> {
    val lst = mutableListOf<Int>()
    var remain = money
    lst.add(remain / 50000)
    remain %= 50000
    lst.add(remain / 10000)
    remain %= 10000
    lst.add(remain / 5000)
    remain %= 5000
    lst.add(remain / 1000)
    remain %= 1000
    lst.add(remain / 500)
    remain %= 500
    lst.add(remain / 100)
    remain %= 100
    lst.add(remain / 50)
    remain %= 50
    lst.add(remain / 10)
    remain %= 10
    lst.add(remain)

    return lst
}

fun main() {
    val money = 150
    print(solution5(money))
}