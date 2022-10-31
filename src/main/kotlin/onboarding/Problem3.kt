package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")

    except3(number)

    return pro3(number)
}

fun except3(number: Int) {
    if(number<1 || number>10000) throw IllegalArgumentException("number는 1 이상 10,000 이하인 자연수")
}
fun pro3(number: Int): Int {
    var cnt: Int = 0
    for(i in 0..number){
        var j = i.toString().count { c -> c == '3' }
        j += i.toString().count { c -> c == '6' }
        j += i.toString().count { c -> c == '9' }
        cnt += j
    }
    return cnt
}