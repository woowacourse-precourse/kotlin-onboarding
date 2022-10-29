package onboarding

fun solution5(money: Int): List<Int> {

    val answer = mutableListOf<Int>(8)

    answer[0] = money/50000
    answer[1] = money%50000/10000
    answer[2] = money%10000/5000
    answer[3] = money%5000/1000
    answer[4] = money%1000/500
    answer[5] = money%500/100
    answer[6] = money%100/50
    answer[7] = money%50/10
    answer[8] = money%10

    return answer

}
