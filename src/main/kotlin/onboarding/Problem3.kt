package onboarding

fun solution3(number: Int): Int {
    var answer = 0

    fun find (num: Int): Int { // 3 6 9 찾기 기능
        val numlist = num.toString().chunked(size = 1).toMutableList() // 분해
        var count = 0

        for (i in 0..numlist.size-1) { // 찾아서 카운트

            if (numlist.get(i) == "3") {
                count += 1
            }
            if (numlist.get(i) == "6") {
                count += 1
            }
            if (numlist.get(i) == "9") {
                count += 1
            }

        }

        return count // 반환
    }

    for (i in 1..number) { // 숫자 1부터 결과값 순차합
        answer = answer + find(i)
    }

    return answer
}
