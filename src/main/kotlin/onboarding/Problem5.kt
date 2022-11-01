package onboarding

fun solution5(money: Int): List<Int> {
    val ans = mutableListOf<Int>()
    val won = mutableListOf(50000,10000,5000,1000,500,100,50,10,1)
    var left_money = money
    for (i:Int in 0.. 8){
        if (left_money/won[i]!=0){
            ans.add(left_money/won[i]) //나눈 몫을 추가
            left_money=(left_money%won[i]) // 나머지는 left_money
        }
        else{
            ans.add(0) // 몫이 없을경우
            left_money=(left_money%won[i])
        }
    }
    return ans
}


