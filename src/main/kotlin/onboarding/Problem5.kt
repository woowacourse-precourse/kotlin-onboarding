package onboarding

fun solution5(money: Int): List<Int> {
    var moneyList = mutableListOf(0,0,0,0,0,0,0,0,0)
    var money = money

    //제한사항 위반 사례 처리
    if (money < 1 || money > 1000000){
        return moneyList
    }
    //오만원 권
    moneyList[0] = money / 50000
    money %= 50000

    //만원 권
    moneyList[1] = money / 10000
    money %= 10000

    //오천원 
    moneyList[2] = money / 5000
    money %= 5000

    //천원 권
    moneyList[3] = money / 1000
    money %= 1000

    //오백원 동전
    moneyList[4] = money / 500
    money %= 500

    //백원 동전
    moneyList[5] = money / 100
    money %= 100

    //오십원 동전
    moneyList[6] = money / 50
    money %= 50

    //십원 동전
    moneyList[7] = money / 10
    money %= 10

    //일원 동전
    moneyList[8] = money / 1
    money %= 1

    return moneyList
}
