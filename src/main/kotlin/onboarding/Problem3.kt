package onboarding
fun solution3(number: Int): Int {
    //TODO("프로그램 구현")
    var result = 0

    for(i: Int in 1..number){
        var num = i
        while (num != 0) {
            if ((num % 10) % 3 == 0 && (num % 10 != 0)) {
                result++
            }
            num /= 10
        }
    }
    return result
}