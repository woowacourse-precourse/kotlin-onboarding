package onboarding

fun solution5(money: Int): List<Int> {
    val wallet = mutableListOf<Int>()
    var money = money
    //50000은 5*2*5*2*5*2*5*2*5*2으로 분해할수 있다.
    var won = 50000
    var index = 1
    while (index < 10) {
        //일원 단위라면 바로 추가
        if (money < 10) {
            wallet.add(money)
        } else {
            //몫 ex 60000이면 5만원권은 1장필요
            val countCoin = money / won
            //나머지 5만원 1장과 남은 10000원
            money = money % won
            wallet.add(countCoin)
            //5를 나눌 경우 10000 2로 나눌 경우 5000 반복하여 1000..500..100..50..10으로계산
            //처음에 50000이들어가고 그다음은 5로나누어 10000그다음은 2로나누어 5000 그다음은 5로 나누어 1000으로 계산
            if (index % 2 == 0) {
                won = won / 2
            } else {
                won = won / 5
            }
        }
        //다음 지폐를 확인하기 위해 인덱스 증가
        index++
    }
    return wallet
}
