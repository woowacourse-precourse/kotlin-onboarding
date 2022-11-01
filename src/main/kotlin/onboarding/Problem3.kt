package onboarding

fun solution3(number: Int): Int {
    /*
    [기능 목록]
    1. 숫자의 각 자릿수가 3,6,9 중 하나인지 판단
    2. 속한다면 카운트 +1, 속하지 않으면 패스
     */
    val gameNum = listOf<Int>(3,6,9)
    var clap = 0

    for (n in 1..number){
        var k = n
        while(k > 0){
            if (k % 10 in gameNum){
                clap += 1
            }
            k /= 10
        }
    }
    return clap
}
