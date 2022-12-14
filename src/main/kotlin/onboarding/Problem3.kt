package onboarding

fun solution3(number: Int): Int {
    return calculateTotal(number)
}

/**
 * 원하는 숫자 (3, 6, 9)를 포함하는 숫자 갯수 반환하는 함수
 */
private fun checkContain(num: Int, standard: Int): Int {
    var count = 0
    for (loop in 1..num) {
        count = count.checkItHasTrigger(loop, standard)
    }
    return count
}

/**
 * 파라미터로 받아오는 수 안에 원하는 수 (3,6,9) 가 몇 개 포함되어 있는지 반환하는 함수
 */
private fun checkHowMuch(param: String, num: Int): Int {
    return param.split("")
        .count { it.contains(num.toString()) } //숫자 각 자리별 비교를 위해 split() 사용하여 분할 후, 각 아이템을 원하는 숫자 (3,6,9)와 비교했다. ex) 33 -> 3, 3
}

private fun calculateTotal(number: Int): Int {
    return standardList().sumOf { checkContain(number, it) }
}

private fun Int.checkItHasTrigger(loop: Int, standard: Int): Int {
    return if (loop.toString().contains(standard.toString())) {
        this + checkHowMuch(loop.toString(), standard)
    } else {
        this
    }
}

private fun standardList() = listOf(3, 6, 9)