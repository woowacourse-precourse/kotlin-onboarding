package onboarding

/**
 * 기능목록
 * (1) 잔액을 화폐단위로 나눈 뒤, 각 단위 별로 몇 개로 변환되는 지 확인한다
 * (2) 기능1에서 확인 된만큼 잔액에서 제하여 주고 잔액을 갱신해준다.
 * (3) 기능1-2를 반복하여 남은 단위도 몇 개가 필요한 지 확인한다.
 * **/
fun solution5(money: Int): List<Int> {
    var balance = money
    val unitList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10) //화폐단위
    var result = mutableListOf<Int>() //각 단위 별로 필요한 수량 목록

    for(i in 0 .. unitList.size-1){
        if(i==unitList.size-1){
            result.add(balance/unitList[i]) //10원 동전 수
            result.add(balance%unitList[i]) //1원 동전 수
            break
        }

        val unitQuantity = balance/unitList[i]
        result.add(unitQuantity) //수량 목록에 추가
        balance %= unitList[i] //잔액 갱신
    }
    return result
}