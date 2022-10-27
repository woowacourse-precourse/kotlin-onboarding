package onboarding

/*
기능항목 정리
1. 큰 지페 순서대로 얼마나 필요한지 구하기
2. 큰 지페 순서대로 리스트에 담기
 */
fun solution5(money: Int): List<Int> {
    var moneyVar=money //variance 로 바꾸기
    var count=0
    var moneyKindList= arrayOf(50000,10000,5000,1000,500,100,50,10,1) //지페 종류 리스트
    var moneyList= arrayListOf<Int>() //지페 개수 담을 어레이리스트

    moneyKindList.forEach { moneyKind->
        count=moneyVar/moneyKind
        moneyList.add(count)
        moneyVar -= moneyKind * count
    }

    return moneyList.toList()
}
