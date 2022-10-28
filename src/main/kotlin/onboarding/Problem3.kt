package onboarding


fun solution3(number: Int): Int {
    var result = 0
    for(i: Int in 1..number) {
        var n = i
        while(n != 0){
            val temp = n % 10
            if(temp != 0 && temp % 3 == 0) {
                result += 1
            }
            n /= 10
        }
    }
    return result
}
