package onboarding

fun solution3(number: Int): Int {
    var numList = MutableList(10001, {i->i})
    for(i in 0..10000) {
        var num:Int = i
        var count:Int = 0
        while(num > 0) {
            val div:Int = num % 10
            if(div == 3 || div == 6 || div == 9) {
                count++
            }
            num /= 10
        }
        numList[i] = count
    }
    var cnt:Int = 0
    for(i in 1..number) {
        cnt += numList[i]
    }
    return cnt
}