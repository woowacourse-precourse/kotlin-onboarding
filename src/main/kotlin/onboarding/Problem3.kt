package onboarding

fun solution3(number: Int): Int {
    var num = number; var count=0
    while(num>0){
        count += checkClap(num.toString())
        num--
    }
    return count
}

fun checkClap(num : String):Int{
    var clapCount = num.count{c -> c == '3'||c=='6'||c=='9' }
    return clapCount
}
