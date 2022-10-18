package onboarding

fun solution3(number: Int): Int {
    var sum : Int = 0
    for (i : Int in 1..number){
        val IntToString: String = i.toString()
        sum += IntToString.count { c -> c == '3' }
        sum += IntToString.count { c -> c == '6' }
        sum += IntToString.count { c -> c == '9' }
    }
    return sum
}
