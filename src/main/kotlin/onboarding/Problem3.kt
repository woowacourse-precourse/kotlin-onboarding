package onboarding

fun solution3(number: Int): Int {
    var sum = 0
    for(i in 1..number){
        var temp = i
        while(temp>0){
            if(temp%10==3 || temp%10==6 || temp%10==9)
                sum++
            temp/=10
        }
    }
    return sum
}
