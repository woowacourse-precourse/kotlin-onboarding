package onboarding

/*
기능항목 정리
1. 각 자릿수를 구하는 기능
2. 각 자릿수마다 3,6,9가 있는지 확인하는 기능
 */
fun solution3(number: Int): Int {
    var answer = 0
    for (i in 1..number) {
        var presentNumber: Int = i
        while (presentNumber != 0) {
            when (presentNumber % 10) {3, 6, 9 -> answer++}
            presentNumber /= 10
        }
    }
    return answer
}


