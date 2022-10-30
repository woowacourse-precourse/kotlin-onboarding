package onboarding

fun solution3(number: Int): Int {
    var cnt=0
    for(i in 1..number){
        var num2=i
        while(true){
            var tmp=num2%10
            if(tmp==3 || tmp==6 || tmp==9){
                cnt+=1
            }
            num2=num2/10
            if(num2==0){
                break
            }
        }
    }
    return cnt
}

