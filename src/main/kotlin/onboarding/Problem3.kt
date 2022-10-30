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
        if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
            cnt++
        }
        num /= 10
    }

    return cnt
}