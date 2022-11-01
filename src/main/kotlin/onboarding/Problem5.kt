package onboarding

fun solution5(money: Int): List<Int> {
    
    //화폐단위 리스트
    //만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
    val unit_list : List<Int> = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    //단위당 각 개수
    var cnt_unit = 0
    //남은돈
    var res_mony = money
    //반환할 값
    var return_list = mutableListOf<Int>()

    //반복문으로 money(=res_money)를 화폐단위 리스트의 각 항목으로 나눔
    unit_list.forEach{ i->
        cnt_unit = (res_mony / i).toInt()
        res_mony = res_mony % i
        return_list.add(cnt_unit)//리턴리스트에 단위 당 개수 추가
    }
    return return_list
}
