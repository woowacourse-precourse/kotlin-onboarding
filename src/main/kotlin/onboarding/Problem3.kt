package onboarding

fun solution3(number: Int): Int {
//    TODO("프로그램 구현")

    var num = number
    var count = 0

    for(i in 1..num)
    {
        if ( i%10 == 3 || i%10 == 6 || i%10 == 9 )
            count+=1

        if ( i/10 == 3 || i/10 == 6 || i/10 == 9)
            count+=1
    }

    // 나머지 값이 3,6,9일때 count 1증가 , 나눈 몫이 3,6,9일때 count 1 증가


    return count
}
