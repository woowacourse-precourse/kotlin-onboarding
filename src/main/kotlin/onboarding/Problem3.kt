package onboarding

fun solution3(number: Int): Int {
    var sum = 0
    for (i in 1..number) {
        sum += count(i)
    }
    return sum
}

fun count(num: Int): Int {
    var input = num
    var cnt = 0
    while (input != 0) {
        if (input % 10 == 3 || input % 10 == 6 || input % 10 == 9)
            cnt++
        input /= 10
    }
    return cnt
}
