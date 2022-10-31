package onboarding

fun solution5(money: Int): List<Int> {
    var answer = arrayListOf<Int>()
    var mo = money
    answer.add(mo/50000)
    mo %= 50000
    answer.add(mo/10000)
    mo %= 10000
    answer.add(mo/5000)
    mo %= 5000
    answer.add(mo/1000)
    mo %= 1000
    answer.add(mo/500)
    mo %= 500
    answer.add(mo/100)
    mo %= 100
    answer.add(mo/50)
    mo %= 50
    answer.add(mo/10)
    mo %= 10
    answer.add(mo)

    return answer.toList()
}
