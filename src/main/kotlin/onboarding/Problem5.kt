package onboarding

//기능 목록
/*
    1. 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 각 화폐 가치 만큼의 수들을 가진 리스트 생성
    2. money를 한 자리씩 비교하면서 1.에서 생성한 리스트를 참고해 변환
    3. 변환한 것을 큰 순서대로 리스트에 담아 return
 */
fun solution5(money: Int): List<Int> {
    //프로그램 구현
    return getCaches(money)
}

fun getCaches(money: Int): List<Int>{

    var temp = 0

    //1. 각 화폐 가치만큼의 수들을 가진 리스트 생성
    val cacheList = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)

    var changedMoney = MutableList<Int>(cacheList.size){ 0 }
    //2. money를 한 자리씩 비교하면서 1.에서 생성한 리스트를 참고해 변환
    for(i in 0 until cacheList.size){
        changedMoney[i] = temp / cacheList[i]
        temp %= cacheList[i]
    }

    return changedMoney

}
