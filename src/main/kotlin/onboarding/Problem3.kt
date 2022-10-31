package onboarding

fun solution3(number: Int): Int {
    var count = 0
    for (i in 0 until number+1)
        count += count369(i)
    return count
}
fun count369(number: Int): Int{
    var num = number
    var count = 0

    while (num != 0) {
        val n = num % 10
        if ((n == 3) or (n == 6) or (n == 9))
            count += 1
        num /= 10
    }
    return count
}