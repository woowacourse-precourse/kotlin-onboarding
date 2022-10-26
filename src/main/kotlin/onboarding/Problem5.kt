package onboarding

fun find_max(num: Int): List<Int> {
    val bills = mutableListOf<Int>(0, 0, 0, 0, 0, 0, 0, 0, 0)
    var n = num
    while (n > 0){
        when (n) {
            in 10000..49999 -> {
                n -= 10000
                bills[1] += 1
            }
            in 5000..9999 -> {
                n -= 5000
                bills[2] += 1
            }
            in 1000..4999 -> {
                n -= 1000
                bills[3] += 1
            }
            in 500..999 -> {
                n -= 500
                bills[4] += 1
            }
            in 100..499 -> {
                n -= 100
                bills[5] += 1
            }
            in 50..99 -> {
                n -= 50
                bills[6] += 1
            }
            in 10..49 -> {
                n -= 10
                bills[7] += 1
            }
            in 1..9 -> {
                n -= 1
                bills[8] += 1
            }
            else -> { // 위의 해당하는 사례가 아닌 경우, 50000보다 크다고 판단
                n -= 50000
                bills[0] += 1
            }
        }
    }
    return bills
}

fun solution5(money: Int): List<Int> {
    return find_max(money)
}
