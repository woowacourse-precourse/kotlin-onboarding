package onboarding

fun solution3(number: Int): Int {
    var count=0
    for (i in 1..number){
        var current =i
        while(current!=0){
            if(current % 10 == 3 || current % 10 == 6 || current % 10 == 9){
                count++
            }
            current/=10
        }
    }
    return count
}
