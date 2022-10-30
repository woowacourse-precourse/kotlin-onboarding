package onboarding

fun solution3(number: Int): Int {
    var count=0
    var index=0
    while(true){
        if(number<index){
            break
        }
        count+=index.toString().count { c -> c == '3' || c == '6' || c == '9' }
        index++
    }
    return count
}

