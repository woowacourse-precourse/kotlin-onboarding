package onboarding

fun solution3(number: Int): Int {
    var answer = 0
    for (i in 1..number) {
        var x = i
        while (x>0) {
            val b = x%10
            if (b==3 || b==6 || b==9) {answer += 1}
            x /= 10
        }
    }
    return answer
}
