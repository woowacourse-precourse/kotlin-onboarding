package onboarding

fun solution5(money: Int): List<Int> {
    //오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원
    val moneyDigit= listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)
    val result= mutableListOf<Int>(0,0,0,0,0,0,0,0,0)
    var curMoney=money

    var i=0
    while(curMoney>0){
        val mNum=curMoney/moneyDigit[i]
        result[i]=mNum
        curMoney-=(mNum*moneyDigit[i])
        i++
    }

    return result
}
