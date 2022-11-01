package onboarding

fun solution5(money: Int): List<Int> {
    var myMoney = money //돈의 액수
    val moneyTypelist = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    //한국 돈 권종별로 정리
    //오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전

    //권종 종류 총합 9개
    val moneyTypeResult = MutableList<Int>(9) { 0 }//0으로 초기화
    for (i in 0 until 9) {
        if (myMoney >= moneyTypelist[i]) {
            moneyTypeResult[i] = myMoney / moneyTypelist[i]
            myMoney -= moneyTypeResult[i] * moneyTypelist[i] //출력리스트에 담은 것은 제외하기
        }
    }
    return moneyTypeResult
}