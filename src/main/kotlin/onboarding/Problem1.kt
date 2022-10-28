package onboarding

fun solution1(pobi: List<Int>, crong: List<Int>): Int {

    fun sum(n: Int): Int { // 분해합 func

        var input = n
        var answer = 0

        while (input != 0) {
            answer += input % 10
            input /= 10
        }

        return answer
    }

    fun mul(n: Int): Int { // 분해곱 func

        var input = n
        var answer = 1

        while (input != 0) {
            answer *= input % 10
            input /= 10
        }

        return answer
    }

    fun high(list: List<Int>) : Int? { // 높은수 func // null이 될수있는 Int 타입 Int?

        val numlist = mutableListOf<Int>() // 변경 가능한 list일 경우 mutableListOf

        for (i:Int in 0..1) {
            numlist.add(sum(list.get(i)))
            numlist.add(mul(list.get(i)))
        }

        return numlist.maxOrNull() // 최신버전에서 max가 안된다.
    }

    if (pobi.get(1)-pobi.get(0) != crong.get(1)-crong.get(0)) // 예외처리
        return -1

    if (high(pobi)!! > high(crong)!!) // 비교후 결과출력 // !! null이 아님을 강제한다.
        return 1
    if (high(pobi)!! < high(crong)!!)
        return 2
    else
        return 0
}
