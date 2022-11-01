package onboarding

fun solution3(number: Int): Int {
    var count = 0
    var tmp = 1
    while(tmp <= number){
        val a = tmp / 100
        val b = (tmp % 100) / 10
        val c = (tmp % 100) % 10

        if(a != 0 && a % 3 == 0) count++
        if(b != 0 && b % 3 == 0) count++
        if(c != 0 && c % 3 == 0) count++

        tmp++
    }
    return count
}
