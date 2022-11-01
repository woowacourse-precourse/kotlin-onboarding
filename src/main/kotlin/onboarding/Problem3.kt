package onboarding

fun solution3(number: Int): Int {
    var cnt=0
    for(i in 1..number+1){
       if (i.toString().contains('3')||i.toString().contains('6')||i.toString().contains('9')){
           cnt++
       }
    }
    return cnt
}
