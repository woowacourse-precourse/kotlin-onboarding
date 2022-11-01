package onboarding

fun solution3(number: Int): Int {
    var answer = 0
    var cnt = 0
    for(num in 1..number){
        var str_num = num.toString()
        answer += str_num.count { it == '3' || it == '6' || it == '9' } // 369 카운트
    }
    return answer
}
