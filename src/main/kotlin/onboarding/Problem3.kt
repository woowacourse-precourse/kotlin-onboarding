package onboarding

fun solution3(number: Int): Int {
    TODO("프로그램 구현")
    var cnt: Int = 0

    for(i in 0..number){
        var j = i.toString().count { c -> c == '3' }
        j += i.toString().count { c -> c == '6' }
        j += i.toString().count { c -> c == '9' }
        cnt += j

    }
    return cnt
}
