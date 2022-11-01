package onboarding

/*
계좌에 들어있는 돈 일부를 은행에서 출금하고자 한다.
돈 담을 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 받는다.
돈의 액수 money가 매개변수로 주어질 때,
오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
각 몇 개로 변환되는지 금액이 큰 순서대로 리스트/배열에 담아 return 하도록 solution 함수를 완성하라.
*/

// money 1 .. 1,000,000


fun calculate(money: Int) :List<Int> {
    var list = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var temp = money
    var cost = mapOf(
        1 to 50000,
        2 to 10000,
        3 to 5000,
        4 to 1000,
        5 to 500,
        6 to 100,
        7 to 50,
        8 to 10,
        9 to 1
    )
    // cost의 값을 자동으로 받아와주기 위해 key 변수 생성
    var key = 1
    while (true) {
        // 잔액이 0원이 되면 끝
        if (temp == 0) {
            break
        }
        for (i in 0 until list.size) {
            // println(temp) 값 로그 확인
            // 잔액이 cost의 값보다 크거나 같으면
            if (temp >= cost.getValue(key)) {
                list[i] = temp / cost.getValue(key) // 몫을 리스트에 넣어줌
                temp %= cost.getValue(key) // 잔액은 넘어가서 반복
            }
            // 키값이 10까지 증가해서 오류가 나길래 만들어줌
            if (key < 9) {
                key += 1
            }
        }
    }
    return list
}


fun solution5(money: Int): List<Int> {
    var temp = money
    return calculate(temp)
}