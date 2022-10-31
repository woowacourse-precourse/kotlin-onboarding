package onboarding

fun solution3(number: Int): Int {
    var cnt: Int = 0

    for (i in 1..number){
        cnt += countClaps(i)
    }

    return cnt
}

fun countClaps(_num: Int): Int {
    var num: Int = _num
    var cnt: Int = 0

    while(num > 0){
        cnt += is369(num % 10)
        num /= 10
    }

    return cnt
}

fun is369(num: Int): Int {
    if (num == 3 || num == 6 || num == 9)
        return 1

    return 0
}