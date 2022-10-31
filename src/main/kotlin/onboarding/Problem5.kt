package onboarding

fun solution5(money: Int): List<Int> {
    var answer = arrayListOf<Int>()
    var mo = money
    answer.plus(mo/50000)
    mo %= 50000
    answer.plus(mo/10000)
    mo %= 10000
    answer.plus(mo/5000)
    mo %= 5000
    answer.plus(mo/1000)
    mo %= 1000
    answer.plus(mo/500)
    mo %= 500
    answer.plus(mo/100)
    mo %= 100
    answer.plus(mo/50)
    mo %= 50
    answer.plus(mo/10)
    mo %= 10
    answer.plus(mo)

    return answer.toList()
}
