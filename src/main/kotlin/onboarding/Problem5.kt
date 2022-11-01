package onboarding

fun solution5(money: Int): List<Int> {
    //val list=MutableList<Int>(9, {i->0}) //지폐와 동전의 갯수를 담을 리스트 생성
    val list=mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
    val unitList:List<Int> = listOf(50000,10000,5000,1000,500,100,50,10,1) //각 화폐의 단위가 저장된 리스트

    if(money<=0){  //0보다 작은 입력이 들어오면 빈 리스트 반환
        return list
    }
    var answer= money

    for(i in 0 until 9){ //9번 반복한다
        list[i]=answer/unitList[i] //큰 단위부터 나누어서 몫을 리스트에 저장
        answer=answer%unitList[i]   // 나눈 나머지를 answer에 저장
    }

    return list
}
