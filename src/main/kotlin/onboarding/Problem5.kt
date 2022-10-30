package onboarding
fun calculate(money: Int, moneyType: ArrayList<Int>): List<Int> {
    var answer = arrayListOf<Int>() //
    var current: Int = money
    for (i in moneyType) {
        answer += (current / i).toInt()
        current = current % i
    }
    return answer
}
fun solution5(money: Int): List<Int> {
    val moneyType = arrayListOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1) //돈을 큰수부터 나누기 위해 내림차순으로 저장
    return calculate(money, moneyType)
}