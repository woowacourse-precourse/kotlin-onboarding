package onboarding

fun solution5(money: Int): List<Int> {
    var remainder = money
    var answer : MutableList<Int> = MutableList(9, {0})
    var divider = listOf<Int>(50000,10000,5000,1000,500,100,50,10,1)

    for (i in divider.indices){
        answer[i] = remainder/divider[i]
        remainder %= divider[i]
    }

    return answer
}

