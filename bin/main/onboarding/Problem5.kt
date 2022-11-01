package onboarding

fun solution5(money: Int): List<Int> {
    // 화페 리스트 선언
    val list_money = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    // 갯수 리스트 선언
    var list_answer = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)

    var balance = money     // 잔액
    var i = 0   // 초기값
    while (balance != 0){   // 잔액이 0이 될때까지 실행
        list_answer[i] = balance / list_money[i]
        balance %= list_money[i]
        i ++
    }
    return list_answer
}
