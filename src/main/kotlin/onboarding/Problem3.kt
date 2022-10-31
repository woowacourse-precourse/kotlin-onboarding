package onboarding

fun solution3(number: Int): Int {
    var ans = 0
    for (i in 1..number) {
        ans += numberOf369(i)
    }
    return ans
}

fun numberOf369(num: Int) : Int{
    var count = 0
    var n = num

    while (n!=0) {
        var temp = n % 10
        if (temp == 3 || temp == 6 || temp == 9) {
            count += 1
        }
        n /= 10
    }

    return count
}
