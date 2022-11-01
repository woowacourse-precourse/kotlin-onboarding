package onboarding

fun solution5(money: Int): List<Int> {
    var num = money
    val unit = listOf<Int>(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1) /* 화폐의 단위를 저장 하는 list */
    var count = arrayListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0) /* 각 화폐 별 개수를 저장 하는 list */

    for(i in 0..unit.size-1){
        var cnt:Int = getCount(num, unit[i])
        count[i] = cnt
        num -= cnt * unit[i]
    }
    return count
}

/* 화폐별 필요한 개수를 리턴하는 메소드 */
fun getCount(num: Int, unit: Int): Int{
    var cnt: Int = num / unit
    return cnt
}


