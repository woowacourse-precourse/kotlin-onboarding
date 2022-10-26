package onboarding

private val threeSixNine = listOf("3", "6", "9")

fun solution3(number: Int): Int {
    var count = 0
    // number 만큼 반복문을 돌린다.
    repeat(number) { i ->
        // 3, 6, 9 개수 만큼 count를 증가
        count += check(i + 1)
    }
    // 1부터 수를 세며 3이 들어가면 count를 올린다.
    // count를 반환한다.
    return count
}

private fun check(number: Int): Int {
    var count = 0
    number.toString().forEach {
        if(it == '3' || it == '6' || it == '9') {
            count++
        }
    }
    return count
}

