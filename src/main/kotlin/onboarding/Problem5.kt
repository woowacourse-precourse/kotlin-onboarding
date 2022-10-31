package onboarding
/*
    기능 목록
    입력된 수를 단위에 따라 나누어 나오는 몫을 저장하는 함수
 */

fun solution5(money: Int): List<Int> {
    var change = money
    val result = mutableListOf<Int>()
    val moneyList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    for (i in moneyList){
        result += change / i
        change %= i
    }

    return result
}