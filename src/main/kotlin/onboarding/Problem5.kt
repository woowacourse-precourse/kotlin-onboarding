package onboarding

/*
1. 화폐 단위 배열 생성, 단위 별로 개수를 담을 배열 생성
2. while 문을 돌려 화폐 단위 배열 순서대로 계산
*/

fun solution5(money: Int): List<Int> {
    val unit = listOf(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1)
    val cost = Array(9){ 0 }

    var n = money
    var idx = 0
    while(n > 0){
        if(n / unit[idx] > 0){
            cost[idx] = n / unit[idx]
            n -= cost[idx]*unit[idx]
        }
        idx++
    }
    return cost.toList()
}
