package onboarding

fun solution3(number: Int): Int {
    var cur: Int = 1
    var ans: Int = 0

    /* 1부터 number까지 돌면서 필요한 박수의 수를 ans에 더한다 */
    while(cur <= number){
        ans += clap(cur)
        cur++
    }
    return ans
}

/* 해당 숫자에 필요한 박수를 리턴하는 메소드 */
fun clap(num: Int): Int {
    var num = num
    var ans: Int = 0
    var temp: Int

    while(num > 0){
        temp = num % 10
        ans += is369(temp)
        num /= 10
    }
    return ans
}

/* 3, 6, 9 인지를 판별하는 메소드 */
fun is369(num: Int): Int{
    if(num % 3 == 0 && num != 0){
        return 1
    }
    return 0
}
