package onboarding

/*
1. 1부터 목표 숫자까지 순회
2. 각 숫자 별로 369게임의 rule에 맞는지 확인
3. rule에 맞다면 answer에 누적해서 더해주기
*/

fun solution3(number: Int): Int {
    var answer = 0
    // 1. 1부터 목표 숫자까지 순회
    for(i in 1 .. number){
        var num = i.toString()
        // 3. rule에 맞다면 answer에 누적해서 더해주기
        answer += check(num)
    }

    return answer
}

// 2. 각 숫자 별로 369게임의 rule에 맞는지 확인
private fun check(num: String): Int {
    var clap = 0
    for (j in num.indices) {
        var str = num.substring(j, j + 1)
        if (str == "3" || str == "6" || str == "9") {
            clap++
        }
    }
    return clap
}
