package onboarding
fun main(){
 println(solution5(50237))
}

fun solution5(money: Int): List<Int> { // 첨엔 반복문 생각했었는데 그리 거창하게 할 필요가 없었음
    val wallet = arrayListOf<Int>() //지갑 배열 추가
    var money = money // 돈
    // 각 변환하고 싶은 단위 별로 나눈 값을 배열 추가 후 단위로 나눈 나머지를 money로 설정
    wallet.add(money/50000)
    money %= 50000

    wallet.add(money/10000)
    money %= 10000

    wallet.add(money/5000)
    money %= 5000

    wallet.add(money/1000)
    money %= 1000

    wallet.add(money/500)
    money %= 500

    wallet.add(money/100)
    money %= 100

    wallet.add(money/50)
    money %= 50

    wallet.add(money/10)
    money %= 10

    wallet.add(money/1)
    money %= 1

    return wallet
}



