package onboarding

fun solution5(money: Int): List<Int> {

    val answer = mutableListOf<Int>()

    answer.add(money/50000) // answer[0] = money 식으로 부여하니까 오류발생
    answer.add(money%50000/10000)
    answer.add(money%10000/5000)
    answer.add(money%5000/1000)
    answer.add(money%1000/500)
    answer.add(money%500/100)
    answer.add(money%100/50)
    answer.add(money%50/10)
    answer.add(money%10)

    return answer

}