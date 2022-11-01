package onboarding


fun calculateRecursive(n: Int): Int {
    // 1보다 작을 때 예외
    if (n < 1){
        return 0
    }
    var flagTrue = 0
    // 1의 자리 수까지 나눔
    if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9) {
        flagTrue = 1
    }
    return calculateRecursive(n / 10) + flagTrue
}

fun solution3(number: Int): Int {
    var count = 0
    for (i in 1..number){
        count += calculateRecursive(i)
    }
    return count
}
