package onboarding

fun solution3(number: Int): Int {
    var count = 0
    var tmp = 1
    while(tmp <= number){ // number는 1만 이하
        val a = tmp / 100 // 백의 자리수
        val b = (tmp % 100) / 10 // 십의 자리수
        val c = (tmp % 100) % 10 // 일의 자리수

        if(a != 0 && a % 3 == 0) count++
        if(b != 0 && b % 3 == 0) count++
        if(c != 0 && c % 3 == 0) count++

        tmp++
    }
    return count
}
