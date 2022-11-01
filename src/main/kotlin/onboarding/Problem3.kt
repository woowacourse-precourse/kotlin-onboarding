package onboarding

fun solution3(number: Int): Int {
    var result = 0

    for (i in 1..number) {
        var variable = i
        // while 사용해서 각 자리수 체크
        while (variable > 0) {
            // 일의 자리 수
            val one = variable % 10
            // 3, 6, 9 if문으로 체크
            if (one == 3 || one == 6 || one == 9) result++

            variable /= 10
        }
    }
    return result
}
