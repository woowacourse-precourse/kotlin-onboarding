package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
}

fun clap(num: Int): Int {
    var num = num
    var ans: Int = 0
    var temp: Int = 0

    while(num > 0){
        temp = num % 10
        ans += is369(temp)
        num /= 10
    }
    return ans
}

fun is369(num: Int): Int{
    if(num % 3 == 0 && num != 0){
        return 1
    }
    return 0
}
