package onboarding

fun solution3(number: Int): Int {
    return check369InNum(number)
}

fun check369InNum(number: Int): Int { // 1..입력값까지, 숫자 3,6,9 포함 시, 카운트+1, 리턴
    var countClap = 0

    for (i in 1..number) {
        var currentNum = i

        while (currentNum > 0) {
            val unitsCurrentNum = currentNum % 10
            if (((unitsCurrentNum) != 0) and ((unitsCurrentNum) % 3 == 0)) {
                countClap++
            }
            currentNum /= 10
        }
    }
    return countClap
}
