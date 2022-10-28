package onboarding

fun solution3(number: Int): Int {
    var answer = 0
    for (num in 1..number) {
        answer += num.toString().count { i -> i == '3' || i == '6' || i == '9' }
    }
    return answer
}
